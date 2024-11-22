CREATE VIEW globox.VW_TITLE_WITH_TWO_OR_MORE_ACTORS AS
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


-- INSERT INTO tb_name_basics (nconst, primary_name, birth_year, death_year)
-- VALUES ('nm0888888', 'ali jamali', 1985, NULL);

-- INSERT INTO tb_title_principals (tconst, category, characters, job, nconst, ordering)
-- VALUES ('tt0004796', 'actor', 'Main Character', NULL, 'nm0888888', 1);