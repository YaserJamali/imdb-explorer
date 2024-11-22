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



-- data for test the scenario
-- اضافه کردن رکوردها به جدول tb_title_basics
# INSERT INTO tb_title_basics (tconst, end_year, is_adult, original_title, primary_title, runtime_minutes, start_year, title_type)
# VALUES ('tt8888888', 2024, 0, 'Test Title 1', 'Test Title 1', 120, 2024, 'movie'),
#        ('tt8888889', 2024, 0, 'Test Title 2', 'Test Title 2', 90, 2024, 'movie');
#
# -- اضافه کردن رکوردها به جدول tb_name_basics
# INSERT INTO tb_name_basics (nconst, primary_name, birth_year, death_year)
# VALUES ('nm8888888', 'Test Actor 1', 1980, NULL),
#        ('nm8888889', 'Test Actor 2', 1985, NULL);
#
# -- اضافه کردن رکوردها به جدول tb_title_principals
# INSERT INTO tb_title_principals (tconst, nconst, category, characters, job, ordering)
# VALUES ('tt8888888', 'nm8888888', 'actor', NULL, NULL, 1),
#        ('tt8888888', 'nm8888889', 'actor', NULL, NULL, 2),
#        ('tt8888889', 'nm8888888', 'actor', NULL, NULL, 1),
#        ('tt8888889', 'nm8888889', 'actor', NULL, NULL, 2);