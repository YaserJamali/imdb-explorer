package com.globox.ali.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;



@Entity
@Table(name = "tb_title_basics")
@Getter
@Setter
public class TitleBasicsEntity extends BaseEntity {
    @Id
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "title_type")
    private String titleType;

    @Column(name = "primary_title")
    private String primaryTitle;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "is_adult")
    private boolean isAdult;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "runtime_minutes")
    private Integer runtimeMinutes;

    @Column(name = "genres")
    private String genres;

    @OneToMany(mappedBy = "titleBasicsEntity")
    private Set<TitleRatingsEntity> ratings;

    @OneToMany(mappedBy = "titleBasicsEntity")
    private Set<TitleCrewEntity> crew;

    @OneToMany(mappedBy = "titleBasicsEntity")
    private Set<TitlePrincipalsEntity> principals;
}



