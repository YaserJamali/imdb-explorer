DROP VIEW IF EXISTS GLOBOX.VW_BEST_MOVIES_PER_YEAR_BASED_ON_IMDB_RANKING;
DROP VIEW IF EXISTS GLOBOX.VW_DIRECTORS_WRITERS_SAME;
DROP VIEW IF EXISTS GLOBOX.VW_DIRECTORS_WRITERS_SAME_AND_ALIVE;
DROP VIEW IF EXISTS GLOBOX.VW_DIRECTORS_WRITERS_SAME_AND_ALIVE_B_NULL;
DROP VIEW IF EXISTS GLOBOX.VW_TITLE_WITH_TWO_OR_MORE_ACTORS;
DROP VIEW IF EXISTS GLOBOX.VW_TITLE_WITH_TWO_OR_MORE_CATEGORY_TYPE;



CREATE VIEW GLOBOX.VW_BEST_MOVIES_PER_YEAR_BASED_ON_IMDB_RANKING AS
WITH RankedMovies AS (SELECT tbt.tconst,
                             tbt.end_year,
                             tbt.is_adult,
                             tbt.original_title,
                             tbt.primary_title,
                             tbt.runtime_minutes,
                             tbt.start_year,
                             tbt.title_type,
                             tbg.title_basics_entity_tconst,
                             tbg.genres,
                             tr.tconst AS rating_tconst,
                             tr.average_rating,
                             tr.number_of_votes,
                             ROW_NUMBER() OVER (PARTITION BY tbt.start_year, tbg.genres ORDER BY tr.average_rating DESC, tr.number_of_votes DESC) AS row_num
                      FROM tb_title_basics tbt
                               JOIN
                           tb_title_ratings tr ON tbt.tconst = tr.tconst
                               JOIN
                           title_basics_entity_genres tbg ON tbt.tconst = tbg.title_basics_entity_tconst
                      WHERE tbt.start_year IS NOT NULL)
SELECT tconst,
       end_year,
       is_adult,
       original_title,
       primary_title,
       runtime_minutes,
       start_year,
       title_type,
       title_basics_entity_tconst,
       genres,
       rating_tconst,
       average_rating,
       number_of_votes
FROM RankedMovies
WHERE row_num = 1
ORDER BY start_year;
CREATE TABLE IF NOT EXISTS `accounts`
(
    `customer_id`
    int
    NOT
    NULL,
    `account_number`
    int
    AUTO_INCREMENT
    PRIMARY
    KEY,
    `account_type`
    varchar
(
    100
) NOT NULL,
    `branch_address` varchar
(
    200
) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar
(
    20
) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar
(
    20
) DEFAULT NULL
    );


create view GLOBOX.VW_DIRECTORS_WRITERS_SAME as
select `tb`.`tconst`                   AS `tconst`,
       `tb`.`end_year`                 AS `end_year`,
       `tb`.`is_adult`                 AS `is_adult`,
       `tb`.`original_title`           AS `original_title`,
       `tb`.`primary_title`            AS `primary_title`,
       `tb`.`runtime_minutes`          AS `runtime_minutes`,
       `tb`.`start_year`               AS `start_year`,
       `tb`.`title_type`               AS `title_type`,
       `tw`.`writers`                  AS `id_of_writer_of_movie`,
       `td`.`directors`                AS `id_of_director_of_movie`,
       `tw`.`title_crew_entity_tconst` AS `id_of_W_movie`,
       `td`.`title_crew_entity_tconst` AS `id_of_D_movie`
from (((`globox`.`tb_title_basics` `tb` join `globox`.`title_crew_entity_directors` `td`
        on ((`tb`.`tconst` = `td`.`title_crew_entity_tconst`))) join `globox`.`title_crew_entity_writers` `tw`
       on ((`tb`.`tconst` = `tw`.`title_crew_entity_tconst`))) join `globox`.`tb_name_basics` `tnb`
      on ((`td`.`directors` = `tnb`.`nconst`)))
where (`td`.`directors` = `tw`.`writers`);


create view GLOBOX.VW_DIRECTORS_WRITERS_SAME_AND_ALIVE as
select `tb`.`tconst`          AS `tconst`,
       `tb`.`end_year`        AS `end_year`,
       `tb`.`is_adult`        AS `is_adult`,
       `tb`.`original_title`  AS `original_title`,
       `tb`.`primary_title`   AS `primary_title`,
       `tb`.`runtime_minutes` AS `runtime_minutes`,
       `tb`.`start_year`      AS `start_year`,
       `tb`.`title_type`      AS `title_type`,
       `tnb`.`nconst`         AS `nconst`,
       `tnb`.`birth_year`     AS `birth_year`,
       `tnb`.`death_year`     AS `death_year`,
       `tnb`.`primary_name`   AS `primary_name`
from (((`globox`.`tb_title_basics` `tb` join `globox`.`title_crew_entity_directors` `td`
        on ((`tb`.`tconst` = `td`.`title_crew_entity_tconst`))) join `globox`.`title_crew_entity_writers` `tw`
       on ((`tb`.`tconst` = `tw`.`title_crew_entity_tconst`))) join `globox`.`tb_name_basics` `tnb`
      on ((`td`.`directors` = `tnb`.`nconst`)))
where ((`td`.`directors` = `tw`.`writers`) and (`tnb`.`death_year` is null) and (`tnb`.`birth_year` is not null));


create view GLOBOX.VW_DIRECTORS_WRITERS_SAME_AND_ALIVE_B_NULL as
select `tb`.`tconst`          AS `tconst`,
       `tb`.`end_year`        AS `end_year`,
       `tb`.`is_adult`        AS `is_adult`,
       `tb`.`original_title`  AS `original_title`,
       `tb`.`primary_title`   AS `primary_title`,
       `tb`.`runtime_minutes` AS `runtime_minutes`,
       `tb`.`start_year`      AS `start_year`,
       `tb`.`title_type`      AS `title_type`,
       `tnb`.`nconst`         AS `nconst`,
       `tnb`.`birth_year`     AS `birth_year`,
       `tnb`.`death_year`     AS `death_year`,
       `tnb`.`primary_name`   AS `primary_name`
from (((`globox`.`tb_title_basics` `tb` join `globox`.`title_crew_entity_directors` `td`
        on ((`tb`.`tconst` = `td`.`title_crew_entity_tconst`))) join `globox`.`title_crew_entity_writers` `tw`
       on ((`tb`.`tconst` = `tw`.`title_crew_entity_tconst`))) join `globox`.`tb_name_basics` `tnb`
      on ((`td`.`directors` = `tnb`.`nconst`)))
where ((`td`.`directors` = `tw`.`writers`) and (`tnb`.`death_year` is null));


CREATE VIEW GLOBOX.VW_TITLE_WITH_TWO_OR_MORE_ACTORS AS
SELECT tbt.tconst,
       tbt.end_year,
       tbt.is_adult,
       tbt.original_title,
       tbt.primary_title,
       tbt.runtime_minutes,
       tbt.start_year,
       tbt.title_type,
       tbn.nconst,
       tbn.primary_name,
       tbn.birth_year,
       tbn.death_year,
       ttp.category,
       ttp.characters,
       ttp.job,
       ttp.ordering
FROM tb_title_basics tbt
         JOIN
     tb_title_principals ttp ON tbt.tconst = ttp.tconst
         JOIN
     tb_name_basics tbn ON ttp.nconst = tbn.nconst
WHERE ttp.category = 'actor'
  AND tbt.tconst IN (SELECT ttp.tconst
                     FROM tb_title_principals ttp
                     WHERE ttp.category = 'actor'
                     GROUP BY ttp.tconst
                     HAVING COUNT(ttp.nconst) >= 2)
ORDER BY tbt.primary_title;

CREATE VIEW GLOBOX.VW_TITLE_WITH_TWO_OR_MORE_CATEGORY_TYPE AS
SELECT tbt.tconst,
       tbt.end_year,
       tbt.is_adult,
       tbt.original_title,
       tbt.primary_title,
       tbt.runtime_minutes,
       tbt.start_year,
       tbt.title_type,
       tbn.nconst,
       tbn.primary_name,
       tbn.birth_year,
       tbn.death_year,
       ttp.category,
       ttp.characters,
       ttp.job,
       ttp.ordering
FROM tb_title_basics tbt
         JOIN
     tb_title_principals ttp ON tbt.tconst = ttp.tconst
         JOIN
     tb_name_basics tbn ON ttp.nconst = tbn.nconst # WHERE ttp.category = 'actor'
         AND tbt.tconst IN (SELECT ttp.tconst
                            FROM tb_title_principals ttp
#                      WHERE ttp.category = 'actor'
                            GROUP BY ttp.tconst
                            HAVING COUNT(ttp.nconst) >= 2)
ORDER BY tbt.primary_title;
