package com.globox.ali.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_title_ratings")
@Getter
@Setter
public class TitleRatingsEntity  extends BaseEntity{
    @Id
    private String tconst;
    @Column(name="AVERAGE_RATING")
    private Double averageRating;
    @Column(name = "NUMBER_OF_VOTES")
    private Integer numVotes;
}