-- CREATE APPLICATION RELATED TABLES

CREATE TABLE IF NOT EXISTS NAME_BASICS_ENTITY_PRIMARY_PROFESSION
(
    NAME_BASICS_ENTITY_NCONST VARCHAR(255) NOT NULL,
    PRIMARY_PROFESSION        VARCHAR(255) NULL,
    CONSTRAINT FK_NAME_BASICS_ENTITY_PRIMARY_PROFESSION_NCONST
        FOREIGN KEY (NAME_BASICS_ENTITY_NCONST) REFERENCES TB_NAME_BASICS (NCONST)
);



CREATE TABLE IF NOT EXISTS TB_NAME_BASICS
(
    NCONST       VARCHAR(255) NOT NULL
        PRIMARY KEY,
    BIRTH_YEAR   INT          NULL,
    DEATH_YEAR   INT          NULL,
    PRIMARY_NAME VARCHAR(255) NULL
);


CREATE TABLE IF NOT EXISTS TB_TITLE_BASICS
(
    TCONST          VARCHAR(255) NOT NULL
        PRIMARY KEY,
    END_YEAR        INT          NULL,
    IS_ADULT        BIT          NULL,
    ORIGINAL_TITLE  VARCHAR(255) NULL,
    PRIMARY_TITLE   VARCHAR(255) NULL,
    RUNTIME_MINUTES INT          NULL,
    START_YEAR      INT          NULL,
    TITLE_TYPE      VARCHAR(255) NULL
);


CREATE TABLE IF NOT EXISTS TB_TITLE_CREW
(
    TCONST VARCHAR(255) NOT NULL
        PRIMARY KEY
);


CREATE TABLE IF NOT EXISTS TB_TITLE_PRINCIPALS
(
    TCONST     VARCHAR(255) NOT NULL,
    CATEGORY   VARCHAR(255) NULL,
    CHARACTERS VARCHAR(255) NULL,
    JOB        VARCHAR(255) NULL,
    NCONST     VARCHAR(255) NULL,
    ORDERING   INT          NOT NULL,
    PRIMARY KEY (TCONST, ORDERING),
    CONSTRAINT FK_TITLE_PRINCIPALS_NCONST
        FOREIGN KEY (NCONST) REFERENCES TB_NAME_BASICS (NCONST),
    CONSTRAINT FK_TITLE_PRINCIPALS_TCONST
        FOREIGN KEY (TCONST) REFERENCES TB_TITLE_BASICS (TCONST)
);

CREATE TABLE IF NOT EXISTS TB_TITLE_RATINGS
(
    TCONST          VARCHAR(255) NOT NULL
        PRIMARY KEY,
    AVERAGE_RATING  DOUBLE       NULL,
    NUMBER_OF_VOTES INT          NULL
);

CREATE TABLE IF NOT EXISTS TITLE_BASICS_ENTITY_GENRES
(
    TITLE_BASICS_ENTITY_TCONST VARCHAR(255) NOT NULL,
    GENRES                     VARCHAR(255) NULL,
    CONSTRAINT FK_TITLE_BASICS_ENTITY_GENRES_TCONST
        FOREIGN KEY (TITLE_BASICS_ENTITY_TCONST) REFERENCES TB_TITLE_BASICS (TCONST)
);

CREATE TABLE IF NOT EXISTS TITLE_CREW_ENTITY_DIRECTORS
(
    TITLE_CREW_ENTITY_TCONST VARCHAR(255) NOT NULL,
    DIRECTORS                VARCHAR(255) NULL,
    CONSTRAINT FK_TITLE_CREW_ENTITY_DIRECTORS_TCONST
        FOREIGN KEY (TITLE_CREW_ENTITY_TCONST) REFERENCES TB_TITLE_CREW (TCONST)
);

CREATE TABLE IF NOT EXISTS TITLE_CREW_ENTITY_WRITERS
(
    TITLE_CREW_ENTITY_TCONST VARCHAR(255) NOT NULL,
    WRITERS                  VARCHAR(255) NULL,
    CONSTRAINT FK_TITLE_CREW_ENTITY_WRITERS_TCONST
        FOREIGN KEY (TITLE_CREW_ENTITY_TCONST) REFERENCES TB_TITLE_CREW (TCONST)
);


-- DROP VIEWS
DROP VIEW IF EXISTS GLOBOX.VW_BEST_GENRES_OF_MOVIES;
DROP VIEW IF EXISTS GLOBOX.VW_CAST_TITLES;
DROP VIEW IF EXISTS GLOBOX.VW_TITLES_DIRECTORS_WRITERS_SAME;

-- CREATE VIEWS AS REQUIRED BY THE APPLICATION SCENARIO


CREATE VIEW GLOBOX.VW_BEST_GENRES_OF_MOVIES AS
WITH RANKEDMOVIES AS (SELECT TBT.TCONST,
                             TBT.END_YEAR,
                             TBT.IS_ADULT,
                             TBT.ORIGINAL_TITLE,
                             TBT.PRIMARY_TITLE,
                             TBT.RUNTIME_MINUTES,
                             TBT.START_YEAR,
                             TBT.TITLE_TYPE,
                             TBG.TITLE_BASICS_ENTITY_TCONST,
                             TBG.GENRES,
                             TR.TCONST AS RATING_TCONST,
                             TR.AVERAGE_RATING,
                             TR.NUMBER_OF_VOTES,
                             ROW_NUMBER() OVER (
                                 PARTITION BY TBT.START_YEAR, TBG.GENRES
                                 ORDER BY TR.NUMBER_OF_VOTES DESC, TR.AVERAGE_RATING DESC
                                 )     AS ROW_NUM
                      FROM TB_TITLE_BASICS TBT
                               JOIN TB_TITLE_RATINGS TR ON TBT.TCONST = TR.TCONST
                               JOIN TITLE_BASICS_ENTITY_GENRES TBG ON TBT.TCONST = TBG.TITLE_BASICS_ENTITY_TCONST
                      WHERE TBT.START_YEAR IS NOT NULL)
SELECT TCONST,
       END_YEAR,
       IS_ADULT,
       ORIGINAL_TITLE,
       PRIMARY_TITLE,
       RUNTIME_MINUTES,
       START_YEAR,
       TITLE_TYPE,
       TITLE_BASICS_ENTITY_TCONST,
       GENRES,
       RATING_TCONST,
       AVERAGE_RATING,
       NUMBER_OF_VOTES
FROM RANKEDMOVIES
WHERE ROW_NUM = 1
ORDER BY START_YEAR;



CREATE VIEW GLOBOX.VW_CAST_TITLES AS
SELECT tb.tconst,
       nb.primary_name,
       tp.nconst,
       tp.category,
       tb.primary_title,
       tb.original_title,
       tb.start_year,
       tb.end_year,
       tb.runtime_minutes,
       tb.title_type

FROM tb_title_basics tb
         JOIN tb_title_principals tp ON tb.tconst = tp.tconst
         JOIN tb_name_basics nb ON tp.nconst = nb.nconst
WHERE tp.category IN ('actor', 'actress')
GROUP BY tb.tconst,
         nb.primary_name,
         tp.nconst,
         tp.category,
         tb.primary_title,
         tb.original_title,
         tb.start_year,
         tb.end_year,
         tb.runtime_minutes,
         tb.title_type;

CREATE VIEW GLOBOX.VW_TITLES_DIRECTORS_WRITERS_SAME AS
SELECT `TB`.`TCONST`          AS `TCONST`,
       `TB`.`END_YEAR`        AS `END_YEAR`,
       `TB`.`IS_ADULT`        AS `IS_ADULT`,
       `TB`.`ORIGINAL_TITLE`  AS `ORIGINAL_TITLE`,
       `TB`.`PRIMARY_TITLE`   AS `PRIMARY_TITLE`,
       `TB`.`RUNTIME_MINUTES` AS `RUNTIME_MINUTES`,
       `TB`.`START_YEAR`      AS `START_YEAR`,
       `TB`.`TITLE_TYPE`      AS `TITLE_TYPE`,
       `TNB`.`NCONST`         AS `NCONST`,
       `TNB`.`BIRTH_YEAR`     AS `BIRTH_YEAR`,
       `TNB`.`DEATH_YEAR`     AS `DEATH_YEAR`,
       `TNB`.`PRIMARY_NAME`   AS `PRIMARY_NAME`
FROM (((`GLOBOX`.`TB_TITLE_BASICS` `TB` JOIN `GLOBOX`.`TITLE_CREW_ENTITY_DIRECTORS` `TD`
        ON ((`TB`.`TCONST` = `TD`.`TITLE_CREW_ENTITY_TCONST`))) JOIN `GLOBOX`.`TITLE_CREW_ENTITY_WRITERS` `TW`
       ON ((`TB`.`TCONST` = `TW`.`TITLE_CREW_ENTITY_TCONST`))) JOIN `GLOBOX`.`TB_NAME_BASICS` `TNB`
      ON ((`TD`.`DIRECTORS` = `TNB`.`NCONST`)))
WHERE ((`TD`.`DIRECTORS` = `TW`.`WRITERS`) AND (`TNB`.`DEATH_YEAR` IS NULL));