
SELECT
    tb.tconst,
    tb.primary_title,
    tb.original_title,
    tb.start_year,
    tb.end_year,
    tb.runtime_minutes,
    tb.title_type,
    MIN(tp1.nconst) AS actor1_nconst,
    MIN(nb1.primary_name) AS actor1_name,
    MIN(tp2.nconst) AS actor2_nconst,
    MIN(nb2.primary_name) AS actor2_name
FROM
    tb_title_basics tb
        JOIN
    tb_title_principals tp1 ON tb.tconst = tp1.tconst
        JOIN
    tb_title_principals tp2 ON tb.tconst = tp2.tconst
        JOIN
    tb_name_basics nb1 ON tp1.nconst = nb1.nconst
        JOIN
    tb_name_basics nb2 ON tp2.nconst = nb2.nconst
WHERE
    tp1.nconst <> tp2.nconst
  AND tp1.category IN ('actor', 'actress')
  AND tp2.category IN ('actor', 'actress')
GROUP BY
    tb.tconst,
    tb.primary_title,
    tb.original_title,
    tb.start_year,
    tb.end_year,
    tb.runtime_minutes,
    tb.title_type;






SELECT
    tb.tconst,
    tp.category,
    tb.primary_title,
    tb.original_title,
    tb.start_year,
    tb.end_year,
    tb.runtime_minutes,
    tb.title_type,
    nb.primary_name AS actor_name
FROM
    tb_title_basics tb
        JOIN
    tb_title_principals tp ON tb.tconst = tp.tconst
        JOIN
    tb_name_basics nb ON tp.nconst = nb.nconst
WHERE
    tp.category = 'actor' OR tp.category = 'actress'
GROUP BY
    tb.tconst,
    tp.category,
    tb.primary_title,
    tb.original_title,
    tb.start_year,
    tb.end_year,
    tb.runtime_minutes,
    tb.title_type,
    nb.primary_name;
