package com.globox.ali.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "tb_title_basics")
@Getter
@Setter
public class TitleBasicsEntity extends BaseEntity {
    @Column(name = "TITL_ETYPE")
    private String titleType;
    @Column(name = "PRIMARY_TITLE")
    private String primaryTitle;
    @Column(name = "ORIGINAL_TITLE")
    private String originalTitle;
    @Column(name = "IS_ADULT")
    private boolean isAdult;
    @Column(name = "START_YEAR")
    private Integer startYear;
    @Column(name = "END_YEAR")
    private Integer endYear;
    @Column(name = "RUNTIMEMINUTES")
    private Integer runtimeMinutes;
    private String genres;
    @OneToMany(mappedBy = "titleBasicsEntity")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitleRatingsEntity> ratings;
    @OneToMany(mappedBy = "titleBasicsEntity")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitleCrewEntity> crew;
    @OneToMany(mappedBy = "titleBasicsEntity")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitlePrincipalsEntity> principals;
}