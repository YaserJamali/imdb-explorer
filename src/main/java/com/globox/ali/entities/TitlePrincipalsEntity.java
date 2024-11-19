package com.globox.ali.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_title_principals")
@Getter
@Setter
public class TitlePrincipalsEntity extends BaseEntity {
    @Column(name = "MOVIE_ID")
    private String movieId;
    private String name;
    private String category;
    @ManyToOne
    @JoinColumn(name = "ACTOR_FR_ID")
    private NameBasicsEntity actor;
    @ManyToOne
    @JoinColumn(name = "TITLE_FR_ID")
    private TitleBasicsEntity titleBasicsEntity;
}