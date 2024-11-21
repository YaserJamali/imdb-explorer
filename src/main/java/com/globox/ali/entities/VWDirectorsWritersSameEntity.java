package com.globox.ali.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "VW_DIRECTORS_WRITERS_SAME")
@Getter
@Setter
public class VWDirectorsWritersSameEntity extends BaseEntity {

    @Id
    private String tconst;
    @Column(name = "end_year")
    private Integer endYear;
    @Column(name = "is_adult")
    private Boolean isAdult;
    @Column(name = "original_title")
    private String originalTitle;
    @Column(name = "primary_title")
    private String primaryTitle;
    @Column(name = "runtime_minutes")
    private Integer runtimeMinutes;
    @Column(name = "start_year")
    private Integer startYear;
    @Column(name = "title_type")
    private String titleType;
    @Column(name = "id_of_writer_of_movie")
    private String idOfWriterOfMovie;
    @Column(name = "id_of_director_of_movie")
    private String idOfDirectorOfMovie;
    @Column(name = "id_of_W_movie")
    private String idOfWMovie;
    @Column(name = "id_of_D_movie")
    private String idOfDMovie;

}
