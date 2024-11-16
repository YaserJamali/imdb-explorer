-- create table for name.basics
CREATE TABLE GLOBOX.TB_NAME_BASICS (
                                nconst VARCHAR(255) PRIMARY KEY,
                                primaryName VARCHAR(255),
                                birthYear INT,
                                deathYear INT,
                                primaryProfession VARCHAR(255),
                                knownForTitles VARCHAR(255)
);

-- create table for title.akas
CREATE TABLE GLOBOX.TB_TITLE_AKAS (
                               titleId VARCHAR(255),
                               ordering INT,
                               title VARCHAR(255),
                               region VARCHAR(255),
                               language VARCHAR(255),
                               types VARCHAR(255),
                               attributes VARCHAR(255),
                               isOriginalTitle BOOLEAN,
                               PRIMARY KEY (titleId, ordering)
);

-- create table for title.basics
CREATE TABLE GLOBOX.TB_TITLE_BASICS (
                                 tconst VARCHAR(20) PRIMARY KEY,
                                 titleType VARCHAR(20),
                                 primaryTitle VARCHAR(255),
                                 originalTitle VARCHAR(255),
                                 isAdult BOOLEAN,
                                 startYear INT,
                                 endYear VARCHAR(10),
                                 runtimeMinutes INT,
                                 genres VARCHAR(255)
);

-- create table for title.crew
CREATE TABLE GLOBOX.TB_TITLE_CREW (
                               tconst VARCHAR(255) PRIMARY KEY,
                               directors TEXT,
                               writers TEXT
);

-- create table for title.episode
CREATE TABLE GLOBOX.TB_TITLE_EPISODE (
                                  tconst VARCHAR(255) PRIMARY KEY,
                                  parentTconst VARCHAR(255),
                                  seasonNumber INT,
                                  episodeNumber INT
);

-- create table for title.principals
CREATE TABLE GLOBOX.TB_TITLE_PRINCIPALS (
                                     tconst VARCHAR(255),
                                     ordering INT,
                                     nconst VARCHAR(255),
                                     category VARCHAR(255),
                                     job VARCHAR(255),
                                     characters VARCHAR(255),
                                     PRIMARY KEY (tconst, ordering, nconst)
);

-- create table for title.ratings
CREATE TABLE GLOBOX.TB_TITLE_RATINGS (
                                  tconst VARCHAR(255) PRIMARY KEY,
                                  averageRating FLOAT,
                                  numVotes INT
);




