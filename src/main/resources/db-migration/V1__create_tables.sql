CREATE TABLE title_principals (
                                  tconst VARCHAR(255),
                                  ordering INT,
                                  nconst VARCHAR(255),
                                  category VARCHAR(255),
                                  job VARCHAR(255),
                                  characters TEXT,
                                  PRIMARY KEY (tconst, ordering, nconst)
);


CREATE TABLE title_ratings (
                               tconst VARCHAR(255) PRIMARY KEY,
                               averageRating FLOAT,
                               numVotes INT
);