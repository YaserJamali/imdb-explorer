package com.globox.ali.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "vw_best_movies_per_year_based_on_imdb_ranking")
@Getter
@Setter

public class VWBestMoviesPerYearBasedOnImdbRankingEntity extends BaseEntity {

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
    @Column(name = "GENRES")
    private String genres;
    @Column(name = "average_rating")
    private Double averageRatings;
    @Column(name = "number_of_votes")
    private String numVotes;
}
