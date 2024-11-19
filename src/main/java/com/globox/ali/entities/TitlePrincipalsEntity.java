package com.globox.ali.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_title_principals")
@Getter
@Setter
public class TitlePrincipalsEntity  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private String movieId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "actor_fr_id")
    private NameBasicsEntity actor;

    @ManyToOne
    @JoinColumn(name = "title_fr_id")
    private TitleBasicsEntity titleBasicsEntity;
}

