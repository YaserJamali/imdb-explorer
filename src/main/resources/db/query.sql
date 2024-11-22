-- 1 بازگرداندن تمام عناوینی که کارگردان و نویسنده یکسان هستند و هنوز زندهاند


#
# تمام عناوینی که کارگردان و نویسنده یکسان دارند
SELECT tb.tconst, tb.primary_title, tb.original_title, tb.start_year, tb.end_year, tw.writers, td.directors
FROM tb_title_basics tb
         JOIN title_crew_entity_directors td ON tb.tconst = td.title_crew_entity_tconst
         JOIN title_crew_entity_writers tw ON tb.tconst = tw.title_crew_entity_tconst
WHERE td.directors = tw.writers;

#
# تمام عناوینی که کارگردان و نویسنده یکسان دارند
# view
CREATE VIEW view_directors_writers_same AS
SELECT tb.*,
       tw.writers                  id_of_writer_of_movie,
       td.directors                id_of_director_of_movie,
       tw.title_crew_entity_tconst id_of_W_movie,
       td.title_crew_entity_tconst id_of_D_movie
FROM tb_title_basics tb
         JOIN title_crew_entity_directors td ON tb.tconst = td.title_crew_entity_tconst
         JOIN title_crew_entity_writers tw ON tb.tconst = tw.title_crew_entity_tconst
WHERE td.directors = tw.writers;

#
# **********************************


SELECT tb.*,
       tw.writers                  id_of_writer_of_movie,
       td.directors                id_of_director_of_movie,
       tw.title_crew_entity_tconst id_of_W_movie,
       td.title_crew_entity_tconst id_of_D_movie
FROM tb_title_basics tb
         JOIN title_crew_entity_directors td ON tb.tconst = td.title_crew_entity_tconst
         JOIN title_crew_entity_writers tw ON tb.tconst = tw.title_crew_entity_tconst
WHERE td.directors = tw.writers;


select tn.*
from tb_name_basics tn
where birth_year IS not NULL
  and death_year is null;


create view VW_VIEW_DIRECTORS_WRITERS_SAME_AND_ALIVE as
SELECT tb.*, tn.*
FROM tb_title_basics tb
         JOIN title_crew_entity_directors td ON tb.tconst = td.title_crew_entity_tconst
         JOIN title_crew_entity_writers tw ON tb.tconst = tw.title_crew_entity_tconst
         JOIN tb_name_basics tn ON td.directors = tn.nconst AND tw.writers = tn.nconst
WHERE td.directors = tw.writers
  AND tn.birth_year IS NOT NULL
  AND tn.death_year IS NULL;

