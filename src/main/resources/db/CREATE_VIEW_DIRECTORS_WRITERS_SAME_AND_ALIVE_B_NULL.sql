create view GLOBOX.VW_VIEW_DIRECTORS_WRITERS_SAME_AND_ALIVE_B_NULL as
select `tb`.`tconst`          AS `tconst`,
       `tb`.`end_year`        AS `end_year`,
       `tb`.`is_adult`        AS `is_adult`,
       `tb`.`original_title`  AS `original_title`,
       `tb`.`primary_title`   AS `primary_title`,
       `tb`.`runtime_minutes` AS `runtime_minutes`,
       `tb`.`start_year`      AS `start_year`,
       `tb`.`title_type`      AS `title_type`,
       `tnb`.`nconst`          AS `nconst`,
       `tnb`.`birth_year`      AS `birth_year`,
       `tnb`.`death_year`      AS `death_year`,
       `tnb`.`primary_name`    AS `primary_name`
FROM
    tb_title_basics tb
        JOIN
    title_crew_entity_directors td ON tb.tconst = td.title_crew_entity_tconst
        JOIN
    title_crew_entity_writers tw ON tb.tconst = tw.title_crew_entity_tconst
        JOIN
    tb_name_basics tnb ON td.directors = tnb.nconst
WHERE
    td.directors = tw.writers
  AND tnb.death_year IS NULL;
-- for alive scenario
INSERT INTO globox.tb_name_basics (nconst, birth_year, death_year, primary_name)
VALUES ('tt0000009', 1986, null, 'Ali Jamali');