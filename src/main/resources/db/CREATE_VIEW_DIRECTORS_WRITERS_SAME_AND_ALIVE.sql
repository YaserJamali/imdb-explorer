create view globox.vw_view_directors_writers_same_and_alive as
select `tb`.`tconst`          AS `tconst`,
       `tb`.`end_year`        AS `end_year`,
       `tb`.`is_adult`        AS `is_adult`,
       `tb`.`original_title`  AS `original_title`,
       `tb`.`primary_title`   AS `primary_title`,
       `tb`.`runtime_minutes` AS `runtime_minutes`,
       `tb`.`start_year`      AS `start_year`,
       `tb`.`title_type`      AS `title_type`,
       `tn`.`nconst`          AS `nconst`,
       `tn`.`birth_year`      AS `birth_year`,
       `tn`.`death_year`      AS `death_year`,
       `tn`.`primary_name`    AS `primary_name`
from (((`globox`.`tb_title_basics` `tb` join `globox`.`title_crew_entity_directors` `td`
        on ((`tb`.`tconst` = `td`.`title_crew_entity_tconst`))) join `globox`.`title_crew_entity_writers` `tw`
       on ((`tb`.`tconst` = `tw`.`title_crew_entity_tconst`))) join `globox`.`tb_name_basics` `tn`
      on (((`td`.`directors` = `tn`.`nconst`) and (`tw`.`writers` = `tn`.`nconst`))))
where ((`td`.`directors` = `tw`.`writers`) and (`tn`.`birth_year` is not null) and (`tn`.`death_year` is null));

-- for alive scenario
-- INSERT INTO globox.tb_name_basics (nconst, birth_year, death_year, primary_name)
-- VALUES ('tt0000009', ۱۹۸۶, null, 'Ali Jamali');