create view globox.vw_view_directors_writers_same_and_alive_b_null as
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

