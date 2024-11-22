-- auto-generated definition
create table tb_known_for_titles
(
    id     bigint auto_increment
        primary key,
    nconst varchar(255) null,
    tconst varchar(255) null,
    constraint FK_nconst_known_for
        foreign key (nconst) references tb_name_basics (nconst),
    constraint FK_tconst_known_for
        foreign key (tconst) references tb_title_basics (tconst)
);

-- auto-generated definition
create table tb_name_basics
(
    nconst       varchar(255) not null
        primary key,
    birth_year   int          null,
    death_year   int          null,
    primary_name varchar(255) null
);

-- auto-generated definition
create table tb_professions
(
    id         bigint auto_increment
        primary key,
    profession varchar(255) null,
    nconst     varchar(255) null,
    constraint FK_nconst_professions
        foreign key (nconst) references tb_name_basics (nconst)
);

-- auto-generated definition
create table tb_title_basics
(
    tconst          varchar(255) not null
        primary key,
    end_year        int          null,
    genres          varchar(255) null,
    is_adult        bit          null,
    original_title  varchar(255) null,
    primary_title   varchar(255) null,
    runtime_minutes int          null,
    start_year      int          null,
    title_type      varchar(255) null
);

-- auto-generated definition
create table tb_title_crew
(
    id          bigint auto_increment
        primary key,
    director_id varchar(255) null,
    title_id    varchar(255) null,
    writer_id   varchar(255) null,
    constraint FK_director
        foreign key (director_id) references tb_name_basics (nconst),
    constraint FK_title
        foreign key (title_id) references tb_title_basics (tconst),
    constraint FK_writer
        foreign key (writer_id) references tb_name_basics (nconst)
);

-- auto-generated definition
create table tb_title_principals
(
    id       bigint auto_increment
        primary key,
    category varchar(255) null,
    tconst   varchar(255) null,
    nconst   varchar(255) null,
    constraint FK_nconst
        foreign key (nconst) references tb_name_basics (nconst),
    constraint FK_tconst
        foreign key (tconst) references tb_title_basics (tconst)
);

-- auto-generated definition
create table tb_title_ratings
(
    tconst          varchar(255) not null
        primary key,
    average_rating  float        null,
    number_of_votes int          null,
    constraint FK_tconst_title_ratings
        foreign key (tconst) references tb_title_basics (tconst)
);


SELECT
    genres,
    COUNT(*) AS genre_count
FROM
    title_basics_entity_genres
GROUP BY
    genres
ORDER BY
    genre_count DESC;