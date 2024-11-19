package com.globox.ali.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_title_ratings")
@Getter
@Setter
public class TitleRatingsEntity extends BaseEntity {
    @Column(name = "AVERAGE_RATING")
    private float averageRating;
    @Column(name = "NUMBER_OF_VOTES")
    private int numVotes;
    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    private TitleBasicsEntity titleBasicsEntity;

}