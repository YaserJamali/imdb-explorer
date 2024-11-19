-- auto-generated definition
create table tb_known_for_titles
(
    id     bigint auto_increment
        primary key,
    nconst varchar(255) null,
    tconst varchar(255) null,
    constraint FK2bqry9qg1d2eaigmmdunucn8n
        foreign key (tconst) references tb_title_basics (tconst),
    constraint FK9ff4jl01v8pcd9jqsx3yfk4n8
        foreign key (nconst) references tb_name_basics (nconst)
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
    constraint FK86k499jy7kb7cpnt0oivsjwdp
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
    constraint FK17h3p16ywphfv7l1ml8eti15a
        foreign key (director_id) references tb_name_basics (nconst),
    constraint FK2h2gt9b97oc9xi0qonskkpd1k
        foreign key (writer_id) references tb_name_basics (nconst),
    constraint FK4xh4ci963m4d9ul24hlxr77p2
        foreign key (title_id) references tb_title_basics (tconst)
);

-- auto-generated definition
create table tb_title_principals
(
    id          bigint auto_increment
        primary key,
    category    varchar(255) null,
    movie_id    varchar(255) null,
    name        varchar(255) null,
    actor_fr_id varchar(255) null,
    title_fr_id varchar(255) null,
    constraint FK1eireafmp943f366uv7elwnym
        foreign key (title_fr_id) references tb_title_basics (tconst),
    constraint FK4k9jh4pcu8ni1nqlgieqwwk9u
        foreign key (actor_fr_id) references tb_name_basics (nconst)
);

-- auto-generated definition
create table tb_title_ratings
(
    tconst          varchar(255) not null
        primary key,
    average_rating  float        null,
    number_of_votes int          null,
    constraint FKp60dpghls31xejpejwmf2jdia
        foreign key (tconst) references tb_title_basics (tconst)
);

