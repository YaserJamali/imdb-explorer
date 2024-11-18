package com.globox.ali.imdb.explorer.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_title_ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleRatingsEntity extends BaseAbstractEntity {
    private float averageRating;
    private int numVotes;
    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    private TitleBasicsEntity titleBasicsEntity;

}