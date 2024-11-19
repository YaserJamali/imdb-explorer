package com.globox.ali.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_title_principals")
@Getter
@Setter
public class TitlePrincipalsEntity extends BaseEntity{
@Column(name = "MOVIE_ID")
    private String movieId;
    private String name;
    private String category;

    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    private TitleBasicsEntity titleBasicsEntity;


}