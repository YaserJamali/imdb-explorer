SELECT category, COUNT(*) AS count
FROM tb_title_principals
GROUP BY category;

#
# cinematographer,۱۴۳۴
# composer,۳۵
# editor,۴۱
# producer,۱۲۱۰
# director,۹۸۲
# production_designer,۶۷
# writer,۱۲۲۸
# actor,۱۱۱
# self,۶
# actress,۷۸
# casting_director,۲
create view temp_view as


SELECT tp1.tconst, tp1.nconst AS actor1, tp2.nconst AS actor2
FROM tb_title_principals tp1
         JOIN tb_title_principals tp2 ON tp1.tconst = tp2.tconst
WHERE tp1.nconst <> tp2.nconst
  AND tp1.category = 'actor'
  AND tp2.category = 'actor'
order by tp1.nconst asc;


SELECT t.*
FROM globox.tb_name_basics t
WHERE nconst = 'nm0071758';



SELECT tbt.*,
       tbn.*,
       ttp.*
FROM tb_title_basics tbt
         JOIN
     tb_title_principals ttp ON tbt.tconst = ttp.tconst
         JOIN
     tb_name_basics tbn ON ttp.nconst = tbn.nconst
WHERE ttp.category = 'actor'
order by tbt.primary_title;


INSERT INTO tb_name_basics (nconst, primary_name, birth_year, death_year)
VALUES ('nm0888888', 'ali jamali', 1985, NULL);



INSERT INTO tb_title_principals (tconst, category, characters, job, nconst, ordering)
VALUES ('tt0004796', 'actor', 'Main Character', NULL, 'nm0888888', 1);


SELECT tbt.*,
       tbn.*,
       ttp.*
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



SELECT tbt.*,
       tbn.*,
       tr.average_rating,
       tr.number_of_votes
FROM tb_title_basics tbt
         JOIN
     tb_title_principals ttp ON tbt.tconst = ttp.tconst
         JOIN
     tb_name_basics tbn ON ttp.nconst = tbn.nconst
         JOIN
     tb_title_ratings tr ON tbt.tconst = tr.tconst #
WHERE ttp.category = 'actor'
  AND tbt.tconst IN (SELECT ttp.tconst
    FROM tb_title_principals ttp
    # WHERE ttp.category = 'actor'
    GROUP BY ttp.tconst
    HAVING COUNT (ttp.nconst) >= 2)
ORDER BY tbt.primary_title;



CREATE VIEW VW_TITLE_WITH_TWO_OR_MORE_CATEGORY_TYPE AS
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
         AND tbt.tconst IN (SELECT ttp.tconst
                            FROM tb_title_principals ttp
                            GROUP BY ttp.tconst
                            HAVING COUNT(ttp.nconst) >= 2)
ORDER BY tbt.primary_title;

CREATE VIEW VW_TITLE_WITH_TWO_OR_MORE_ACTORS AS
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