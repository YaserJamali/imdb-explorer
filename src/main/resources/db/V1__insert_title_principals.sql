CREATE TABLE globox.tb_title_principals
(
    tconst   varchar(255) not null,
    ordering int not null,
    nconst   varchar(255) not null,
    category varchar(255) null,
    job      varchar(255) null,
    characters varchar(255) null,
    primary key (tconst, ordering, nconst),
    constraint FKqk3dec0inpvglwlmne2lkrhsm
        foreign key (tconst) references globox.tb_title_basics (tconst)
);

INSERT INTO GLOBOX.TB_TITLE_PRINCIPALS (tconst, ordering, nconst, category, job, characters)
VALUES ('tt0000001', 1, 'nm0000001', 'director', 'director', '\N'),
       ('tt0000001', 2, 'nm0000002', 'actor', '\N', 'Carmencita'),
       ('tt0000002', 1, 'nm0000003', 'director', 'director', '\N'),
       ('tt0000002', 2, 'nm0000004', 'actor', '\N', 'Clown'),
       ('tt0000003', 1, 'nm0000005', 'director', 'director', '\N'),
       ('tt0000003', 2, 'nm0000006', 'actor', '\N', 'Pierrot'),
       ('tt0000004', 1, 'nm0000007', 'director', 'director', '\N'),
       ('tt0000004', 2, 'nm0000008', 'actor', '\N', 'Bock'),
       ('tt0000005', 1, 'nm0000009', 'director', 'director', '\N'),
       ('tt0000005', 2, 'nm0000010', 'actor', '\N', 'Blacksmith'),
       ('tt0000006', 1, 'nm0000011', 'director', 'director', '\N'),
       ('tt0000006', 2, 'nm0000012', 'actor', '\N', 'Opium Den Patron'),
       ('tt0000007', 1, 'nm0000013', 'director', 'director', '\N'),
       ('tt0000007', 2, 'nm0000014', 'actor', '\N', 'Corbett'),
       ('tt0000008', 1, 'nm0000015', 'director', 'director', '\N'),
       ('tt0000008', 2, 'nm0000016', 'actor', '\N', 'Sneezer'),
       ('tt0000009', 1, 'nm0000017', 'director', 'director', '\N'),
       ('tt0000009', 2, 'nm0000018', 'actor', '\N', 'Miss Jerry'),
       ('tt0000010', 1, 'nm0000019', 'director', 'director', '\N'),
       ('tt0000010', 2, 'nm0000020', 'actor', '\N', 'Factory Worker');





INSERT INTO tb_title_principals (tconst, ordering, nconst, category, job, characters)
VALUES
    ('tt0000031', 1, 'nm0000031', 'actor', 'Lead Actor', 'Character 31'),
    ('tt0000032', 2, 'nm0000032', 'director', 'Director', 'Character 32'),
    ('tt0000033', 3, 'nm0000033', 'producer', 'Producer', 'Character 33'),
    ('tt0000034', 4, 'nm0000034', 'writer', 'Writer', 'Character 34'),
    ('tt0000035', 5, 'nm0000035', 'actor', 'Supporting Actor', 'Character 35'),
    ('tt0000036', 6, 'nm0000036', 'actress', 'Lead Actress', 'Character 36'),
    ('tt0000037', 7, 'nm0000037', 'composer', 'Composer', 'Character 37'),
    ('tt0000038', 8, 'nm0000038', 'cinematographer', 'Cinematographer', 'Character 38'),
    ('tt0000039', 9, 'nm0000039', 'editor', 'Editor', 'Character 39'),
    ('tt0000040', 10, 'nm0000040', 'costume designer', 'Costume Designer', 'Character 40'),
    ('tt0000041', 11, 'nm0000041', 'actor', 'Lead Actor', 'Character 41'),
    ('tt0000042', 12, 'nm0000042', 'director', 'Director', 'Character 42'),
    ('tt0000043', 13, 'nm0000043', 'producer', 'Producer', 'Character 43'),
    ('tt0000044', 14, 'nm0000044', 'writer', 'Writer', 'Character 44'),
    ('tt0000045', 15, 'nm0000045', 'actor', 'Supporting Actor', 'Character 45'),
    ('tt0000046', 16, 'nm0000046', 'actress', 'Lead Actress', 'Character 46'),
    ('tt0000047', 17, 'nm0000047', 'composer', 'Composer', 'Character 47'),
    ('tt0000048', 18, 'nm0000048', 'cinematographer', 'Cinematographer', 'Character 48'),
    ('tt0000049', 19, 'nm0000049', 'editor', 'Editor', 'Character 49'),
    ('tt0000050', 20, 'nm0000050', 'costume designer', 'Costume Designer', 'Character 50'),
    ('tt0000051', 21, 'nm0000051', 'actor', 'Lead Actor', 'Character 51'),
    ('tt0000052', 22, 'nm0000052', 'director', 'Director', 'Character 52'),
    ('tt0000053', 23, 'nm0000053', 'producer', 'Producer', 'Character 53'),
    ('tt0000054', 24, 'nm0000054', 'writer', 'Writer', 'Character 54'),
    ('tt0000055', 25, 'nm0000055', 'actor', 'Supporting Actor', 'Character 55'),
    ('tt0000056', 26, 'nm0000056', 'actress', 'Lead Actress', 'Character 56'),
    ('tt0000057', 27, 'nm0000057', 'composer', 'Composer', 'Character 57'),
    ('tt0000058', 28, 'nm0000058', 'cinematographer', 'Cinematographer', 'Character 58'),
    ('tt0000059', 29, 'nm0000059', 'editor', 'Editor', 'Character 59'),
    ('tt0000060', 30, 'nm0000060', 'costume designer', 'Costume Designer', 'Character 60');
