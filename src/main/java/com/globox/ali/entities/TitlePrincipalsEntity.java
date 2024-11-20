package com.globox.ali.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_title_principals")
@Getter
@Setter
public class TitlePrincipalsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "tconst")
    private TitleBasicsEntity titleBasicsEntity;

    @ManyToOne
    @JoinColumn(name = "nconst")
    private NameBasicsEntity actor;
}
