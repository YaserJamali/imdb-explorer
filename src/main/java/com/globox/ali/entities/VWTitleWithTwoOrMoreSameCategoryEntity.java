package com.globox.ali.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "VW_TITLE_WITH_TWO_OR_MORE_CATEGORY_TYPE")
@Getter
@Setter

public class VWTitleWithTwoOrMoreSameCategoryEntity extends BaseEntity {

    @Id
    private String tconst;
    @Column(name = "END_YEAR")
    private Integer endYear;
    @Column(name = "IS_ADULT")
    private Boolean isAdult;
    @Column(name = "ORIGINAL_TITLE")
    private String originalTitle;
    @Column(name = "PRIMARY_TITLE")
    private String primaryTitle;
    @Column(name = "RUNTIME_MINUTES")
    private Integer runtimeMinutes;
    @Column(name = "START_YEAR")
    private Integer startYear;
    @Column(name = "TITLE_TYPE")
    private String titleType;
    @Column(name = "nconst")
    private String nconst;
    @Column(name = "primary_name")
    private String primaryName;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "death_year")
    private Integer deathYear;
    @Column(name = "category")
    private String category;
    @Column(name = "characters")
    private String characters;
    @Column(name = "job")
    private String job;
    @Column(name = "ordering")
    private String ordering;
}
