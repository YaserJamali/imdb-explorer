
SELECT
    tbg.genres,
    tbt.start_year,
    tbt.primary_title,
    tbt.title_type,
    tr.average_rating,
    tr.number_of_votes
FROM
    tb_title_basics tbt
        JOIN
    tb_title_ratings tr ON tbt.tconst = tr.tconst
        JOIN
    title_basics_entity_genres tbg ON tbt.tconst = tbg.title_basics_entity_tconst
WHERE
    tbg.genres = 'Comedy' -- جایگزین 'desired_genre' با ژانر مورد نظر شما
  AND
    tbt.start_year IS NOT NULL
ORDER BY
    tbt.start_year,
    tr.number_of_votes DESC,
    tr.average_rating DESC;



SELECT
    tbg.genres,
    tbt.start_year,
    tbt.primary_title,
    tbt.title_type,
    tr.average_rating,
    tr.number_of_votes
FROM
    tb_title_basics tbt
        JOIN
    tb_title_ratings tr ON tbt.tconst = tr.tconst
        JOIN
    title_basics_entity_genres tbg ON tbt.tconst = tbg.title_basics_entity_tconst
WHERE
    tbt.start_year IS NOT NULL
  AND tbg.genres = 'Romance' -- جایگزین 'desired_genre' با ژانر مورد نظر شما
ORDER BY
    tbt.start_year,
    tr.average_rating DESC,
    tr.number_of_votes DESC;




WITH RankedMovies AS (
    SELECT
        tbt.start_year,
        tbt.primary_title,
        tbt.title_type,
        tbg.genres,
        tr.average_rating,
        tr.number_of_votes,
        ROW_NUMBER() OVER (PARTITION BY tbt.start_year, tbg.genres ORDER BY tr.average_rating DESC, tr.number_of_votes DESC) AS row_num
    FROM
        tb_title_basics tbt
            JOIN
        tb_title_ratings tr ON tbt.tconst = tr.tconst
            JOIN
        title_basics_entity_genres tbg ON tbt.tconst = tbg.title_basics_entity_tconst
    WHERE
        tbt.start_year IS NOT NULL
      AND tbg.genres = 'Romance' -- جایگزین 'Romance' با ژانر مورد نظر شما
)
SELECT
    genres,
    start_year,
    primary_title,
    title_type,
    average_rating,
    number_of_votes
FROM
    RankedMovies
WHERE
    row_num = 1
ORDER BY
    start_year;






CREATE VIEW VW_BEST_MOVIES_PER_YEAR_BASED_ON_IMDB_RANKING AS
WITH RankedMovies AS (
    SELECT
        tbt.tconst,
        tbt.end_year,
        tbt.is_adult,
        tbt.original_title,
        tbt.primary_title,
        tbt.runtime_minutes,
        tbt.start_year,
        tbt.title_type,
        tbg.title_basics_entity_tconst,
        tbg.genres,
        tr.tconst AS rating_tconst,
        tr.average_rating,
        tr.number_of_votes,
        ROW_NUMBER() OVER (PARTITION BY tbt.start_year, tbg.genres ORDER BY tr.average_rating DESC, tr.number_of_votes DESC) AS row_num
    FROM
        tb_title_basics tbt
            JOIN
        tb_title_ratings tr ON tbt.tconst = tr.tconst
            JOIN
        title_basics_entity_genres tbg ON tbt.tconst = tbg.title_basics_entity_tconst
    WHERE
        tbt.start_year IS NOT NULL
)
SELECT
    tconst,
    end_year,
    is_adult,
    original_title,
    primary_title,
    runtime_minutes,
    start_year,
    title_type,
    title_basics_entity_tconst,
    genres,
    rating_tconst,
    average_rating,
    number_of_votes
FROM
    RankedMovies
WHERE
    row_num = 1
ORDER BY
    start_year;






























