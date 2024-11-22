package com.globox.ali.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "vw_directors_writers_same_and_alive")
@Getter
@Setter
public class VWDirectorsWritersSameAndAliveEntity extends BaseEntity {
    @Id
    private String tconst;
    @Column(name = "TITLE_TYPE")
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
    @Column(name = "RUNTIME_MINUTES")
    private Integer runtimeMinutes;
    private String nconst;
    @Column(name = "PRIMARY_NAME")
    private String primaryName;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "DEATH_YEAR")
    private Integer deathYear;
}
