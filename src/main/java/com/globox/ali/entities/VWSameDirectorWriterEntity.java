package com.globox.ali.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "VW_TITLES_DIRECTORS_WRITERS_SAME")
@Getter
@Immutable
public class VWSameDirectorWriterEntity extends BaseEntity {

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
}
