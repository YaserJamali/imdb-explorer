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
