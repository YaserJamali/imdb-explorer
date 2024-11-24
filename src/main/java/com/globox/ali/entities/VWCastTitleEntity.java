package com.globox.ali.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "VW_CAST_TITLES")
@Getter
@Immutable
public class VWCastTitleEntity extends BaseEntity {

    @Id
    @Column(name = "TCONST")
    private String tconst;
    @Column(name = "NCONST")
    private String nconst;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "PRIMARY_TITLE")
    private String primaryTitle;
    @Column(name = "ORIGINAL_TITLE")
    private String originalTitle;
    @Column(name = "START_YEAR")
    private Integer startYear;
    @Column(name = "END_YEAR")
    private Integer endYear;
    @Column(name = "RUNTIME_MINUTES")
    private Integer runtimeMinutes;
    @Column(name = "TITLE_TYPE")
    private String titleType;
    @Column(name = "PRIMARY_NAME")
    private String primaryName;
}
