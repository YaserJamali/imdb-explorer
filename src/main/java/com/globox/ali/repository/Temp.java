//package com.globox.ali.repository;
//
//import com.globox.ali.entities.BaseEntity;
//
//public class Temp {
//
//}
//
////کلاس NameBasicsEntity
//@Entity
//@Table(name = "tb_name_basics")
//@Getter
//@Setter
//public class NameBasicsEntity {
//    @Id
//    @Column(name = "nconst")
//    private String nconst;
//
//    @Column(name = "primary_name")
//    private String primaryName;
//
//    @Column(name = "birth_year")
//    private Integer birthYear;
//
//    @Column(name = "death_year")
//    private Integer deathYear;
//
//    @OneToMany(mappedBy = "nameBasicsEntity")
//    private Set<ProfessionEntity> professions;
//
//    @OneToMany(mappedBy = "nameBasicsEntity")
//    private Set<KnownForTitleEntity> knownForTitles;
//
//    @OneToMany(mappedBy = "director")
//    private Set<TitleCrewEntity> directedTitles;
//
//    @OneToMany(mappedBy = "writer")
//    private Set<TitleCrewEntity> writtenTitles;
//
//    @OneToMany(mappedBy = "actor")
//    private Set<TitlePrincipalsEntity> actedTitles;
//}
//
////کلاس ProfessionEntity
////@Entity
////@Table(name = "tb_professions")
////@Getter
////@Setter
////public class ProfessionEntity {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @Column(name = "profession")
////    private String profession;
////
////    @ManyToOne
////    @JoinColumn(name = "nconst")
////    private NameBasicsEntity nameBasicsEntity;
////}
//
////کلاس KnownForTitleEntity
////@Entity
////@Table(name = "tb_known_for_titles")
////@Getter
////@Setter
////public class KnownForTitleEntity {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @ManyToOne
////    @JoinColumn(name = "nconst")
////    private NameBasicsEntity nameBasicsEntity;
////
////    @ManyToOne
////    @JoinColumn(name = "tconst")
////    private TitleBasicsEntity titleBasicsEntity;
////}
//
////کلاس TitleBasicsEntity
//@Entity
//@Table(name = "tb_title_basics")
//@Getter
//@Setter
//public class TitleBasicsEntity {
//    @Id
//    @Column(name = "tconst")
//    private String tconst;
//
//    @Column(name = "title_type")
//    private String titleType;
//
//    @Column(name = "primary_title")
//    private String primaryTitle;
//
//    @Column(name = "original_title")
//    private String originalTitle;
//
//    @Column(name = "is_adult")
//    private boolean isAdult;
//
//    @Column(name = "start_year")
//    private Integer startYear;
//
//    @Column(name = "end_year")
//    private Integer endYear;
//
//    @Column(name = "runtime_minutes")
//    private Integer runtimeMinutes;
//
//    @Column(name = "genres")
//    private String genres;
//
//    @OneToMany(mappedBy = "titleBasicsEntity")
//    private Set<TitleRatingsEntity> ratings;
//
//    @OneToMany(mappedBy = "titleBasicsEntity")
//    private Set<TitleCrewEntity> crew;
//
//    @OneToMany(mappedBy = "titleBasicsEntity")
//    private Set<TitlePrincipalsEntity> principals;
//}
//
////کلاس TitleCrewEntity
////@Entity
////@Table(name = "tb_title_crew")
////@Getter
////@Setter
////public class TitleCrewEntity extends BaseEntity {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @ManyToOne
////    @JoinColumn(name = "director_id")
////    private NameBasicsEntity director;
////
////    @ManyToOne
////    @JoinColumn(name = "writer_id")
////    private NameBasicsEntity writer;
////
////    @ManyToOne
////    @JoinColumn(name = "title_id")
////    private TitleBasicsEntity titleBasicsEntity;
////}
//
////کلاس TitlePrincipalsEntity
////@Entity
////@Table(name = "tb_title_principals")
////@Getter
////@Setter
////public class TitlePrincipalsEntity {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @Column(name = "movie_id")
////    private String movieId;
////
////    @Column(name = "name")
////    private String name;
////
////    @Column(name = "category")
////    private String category;
////
////    @ManyToOne
////    @JoinColumn(name = "actor_fr_id")
////    private NameBasicsEntity actor;
////
////    @ManyToOne
////    @JoinColumn(name = "title_fr_id")
////    private TitleBasicsEntity titleBasicsEntity;
////}
//
////کلاس TitleRatingsEntity
//@Entity
//@Table(name = "tb_title_ratings")
//@Getter
//@Setter
//public class TitleRatingsEntity {
//    @Id
//    @Column(name = "tconst")
//    private String tconst;
//
//    @Column(name = "average_rating")
//    private float averageRating;
//
//    @Column(name = "number_of_votes")
//    private int numVotes;
//
//    @ManyToOne
//    @JoinColumn(name = "tconst", insertable = false, updatable = false)
//    private TitleBasicsEntity titleBasicsEntity;
