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
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "average_rating")
    private float averageRating;

    @Column(name = "number_of_votes")
    private int numVotes;

    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    private TitleBasicsEntity titleBasicsEntity;
}