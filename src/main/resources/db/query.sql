-- 1 بازگرداندن تمام عناوینی که کارگردان و نویسنده یکسان هستند و هنوز زندهاند


SELECT tb.*,
       tw.writers                  AS id_of_writer_of_movie,
       td.directors                AS id_of_director_of_movie,
       tw.title_crew_entity_tconst AS id_of_W_movie,
       td.title_crew_entity_tconst AS id_of_D_movie,
       tnb.primary_name            AS director_writer_name,
       tnb.birth_year              AS director_writer_birth_year,
       tnb.death_year              AS director_writer_death_year
FROM tb_title_basics tb
         JOIN
     title_crew_entity_directors td ON tb.tconst = td.title_crew_entity_tconst
         JOIN
     title_crew_entity_writers tw ON tb.tconst = tw.title_crew_entity_tconst
         JOIN
     tb_name_basics tnb ON td.directors = tnb.nconst
WHERE td.directors = tw.writers
  AND tnb.death_year IS NULL;


# **********************************

SELECT tb.primary_title,
       tb.original_title,
       tb.tconst,
       tb.start_year,
       tb.end_year,
       tb.title_type,
       tb.is_adult,
       tb.runtime_minutes,
       tw.writers                  AS id_of_writer_of_movie,
       td.directors                AS id_of_director_of_movie,
       tw.title_crew_entity_tconst AS id_of_W_movie,
       td.title_crew_entity_tconst AS id_of_D_movie,
       tnb.primary_name            AS director_writer_name,
       tnb.birth_year              AS director_writer_birth_year,
       tnb.death_year              AS director_writer_death_year
FROM tb_title_basics tb
         JOIN
     title_crew_entity_directors td ON tb.tconst = td.title_crew_entity_tconst
         JOIN
     title_crew_entity_writers tw ON tb.tconst = tw.title_crew_entity_tconst
         JOIN
     tb_name_basics tnb ON td.directors = tnb.nconst
WHERE td.directors = tw.writers
  AND tnb.death_year IS NULL
  AND tnb.birth_year IS NOT NULL;

-- ********************************************************


INSERT INTO tb_title_crew (tconst)
VALUES ('tt9999999');


INSERT INTO tb_title_basics (tconst, end_year, is_adult, original_title, primary_title, runtime_minutes, start_year,
                             title_type)
VALUES ('tt9999999', NULL, FALSE, 'Example Movie', 'Example Movie', 120, 2024, 'movie');


INSERT INTO title_crew_entity_directors (title_crew_entity_tconst, directors)
VALUES ('tt9999999', 'nm9999999');


INSERT INTO title_crew_entity_writers (title_crew_entity_tconst, writers)
VALUES ('tt9999999', 'nm9999999');


INSERT INTO tb_name_basics (nconst, birth_year, death_year, primary_name)
VALUES ('nm9999999', 1965, NULL, 'Ali Kamali');
