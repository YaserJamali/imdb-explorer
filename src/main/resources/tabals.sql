-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.NAME_BASICS_ENTITY_KNOWN_FOR_TITLES
(
    name_basics_entity_nconst
    varchar
(
    255
) not null,
    known_for_titles varchar
(
    255
) null,
    constraint FK2xyqwj4g2x42ahedarfg2hqaq
    foreign key
(
    name_basics_entity_nconst
) references tb_name_basics
(
    nconst
)
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.name_basics_entity_primary_profession
(
    name_basics_entity_nconst
    varchar
(
    255
) not null,
    primary_profession varchar
(
    255
) null,
    constraint FKdm7g2n2718q5lfwa6f5u7i52
    foreign key
(
    name_basics_entity_nconst
) references tb_name_basics
(
    nconst
)
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.TB_NAME_BASICS
(
    nconst
    varchar
(
    255
) not null
    primary key,
    birth_year int null,
    death_year int null,
    primary_name varchar
(
    255
) null
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.TB_TITLE_BASICS
(
    tconst
    varchar
(
    255
) not null
    primary key,
    end_year int null,
    is_adult bit null,
    original_title varchar
(
    255
) null,
    primary_title varchar
(
    255
) null,
    runtime_minutes int null,
    start_year int null,
    title_type varchar
(
    255
) null
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.TB_TITLE_CREW
(
    tconst
    varchar
(
    255
) not null
    primary key
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.TB_TITLE_PRINCIPALS
(
    tconst
    varchar
(
    255
) not null,
    category varchar
(
    255
) null,
    characters varchar
(
    255
) null,
    job varchar
(
    255
) null,
    nconst varchar
(
    255
) null,
    ordering int not null,
    primary key
(
    tconst,
    ordering
)
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.TB_TITLE_RATINGS
(
    tconst
    varchar
(
    255
) not null
    primary key,
    average_rating double null,
    number_of_votes int null
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.TITLE_BASICS_ENTITY_GENRES
(
    title_basics_entity_tconst
    varchar
(
    255
) not null,
    genres varchar
(
    255
) null,
    constraint FKp3hbfwdbicnmbaut1xf58abd5
    foreign key
(
    title_basics_entity_tconst
) references tb_title_basics
(
    tconst
)
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS GLOBOX.TITLE_CREW_ENTITY_DIRECTORS
(
    title_crew_entity_tconst
    varchar
(
    255
) not null,
    directors varchar
(
    255
) null,
    constraint FK9146gx8109j9i9g3a6ukm9hcm
    foreign key
(
    title_crew_entity_tconst
) references tb_title_crew
(
    tconst
)
    );

-- auto-generated definition
CREATE TABLE IF NOT EXISTS  GLOBOX.TITLE_CREW_ENTITY_WRITERS
(
    title_crew_entity_tconst
    varchar
(
    255
) not null,
    writers varchar
(
    255
) null,
    constraint FKmvpit47u27h97fqs5ni4havwb
    foreign key
(
    title_crew_entity_tconst
) references tb_title_crew
(
    tconst
)
    );

