-- 1 بازگرداندن تمام عناوینی که کارگردان و نویسنده یکسان هستند و هنوز زندهاند


SELECT tb.* ,tc.*
FROM tb_title_basics tb
         JOIN tb_title_crew tc ON tb.tconst = tc.title_id
         JOIN tb_name_basics nb ON tc.director_id = nb.nconst AND tc.writer_id = nb.nconst
WHERE nb.death_year IS NULL;


#  2. بازگرداندن تمام عناوینی که دو بازیگر در آن بازی کردهاند


SELECT tb.*
FROM tb_title_basics tb
         JOIN tb_title_principals tp1 ON tb.tconst = tp1.tconst
         JOIN tb_title_principals tp2 ON tb.tconst = tp2.tconst
WHERE tp1.nconst = 'actor1Id'
  AND tp2.nconst = 'actor2Id';







-- اول این کوری را میزنیم سپس از خروجی آن

SELECT tp1.nconst AS actor1, tp2.nconst AS actor2, tb.primary_title
FROM tb_title_principals tp1
         JOIN tb_title_principals tp2 ON tp1.tconst = tp2.tconst
         JOIN tb_title_basics tb ON tp1.tconst = tb.tconst
WHERE tp1.nconst <> tp2.nconst;

-- نمونه

SELECT tb.*
FROM tb_title_basics tb
         JOIN tb_title_principals tp1 ON tb.tconst = tp1.tconst
         JOIN tb_title_principals tp2 ON tb.tconst = tp2.tconst
WHERE tp1.nconst = 'nm2263402'
  AND tp2.nconst = 'nm0492774';


SELECT tb.*
FROM tb_title_basics tb
         JOIN tb_title_principals tp1 ON tb.tconst = tp1.tconst
         JOIN tb_title_principals tp2 ON tb.tconst = tp2.tconst
WHERE tp1.nconst = ?
  AND tp2.nconst = ?;


#     3. بازگرداندن بهترین عناوین هر سال برای یک ژانر بر اساس تعداد آرا و امتیاز


SELECT tb.*, tr.average_rating, tr.number_of_votes
FROM tb_title_basics tb
         JOIN tb_title_ratings tr ON tb.tconst = tr.tconst
         JOIN (SELECT b.start_year, b.tconst, MAX(tr.average_rating) AS max_rating
               FROM tb_title_basics b
                        JOIN tb_title_ratings tr ON b.tconst = tr.tconst
               WHERE b.genres LIKE '%com%'
               GROUP BY b.start_year, b.tconst) max_ratings
              ON tb.tconst = max_ratings.tconst AND tr.average_rating = max_ratings.max_rating
ORDER BY tb.start_year, tr.average_rating DESC, tr.number_of_votes DESC;

