create view globox.view_directors_writers_same as
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
from ((`globox`.`tb_title_basics` `tb` join `globox`.`title_crew_entity_directors` `td`
       on ((`tb`.`tconst` = `td`.`title_crew_entity_tconst`))) join `globox`.`title_crew_entity_writers` `tw`
      on ((`tb`.`tconst` = `tw`.`title_crew_entity_tconst`)))
where (`td`.`directors` = `tw`.`writers`);