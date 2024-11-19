package com.globox.ali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_known_for_titles")
@Getter
@Setter
public class KnownForTitleEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nconst")
    private NameBasicsEntity nameBasicsEntity;

    @ManyToOne
    @JoinColumn(name = "tconst")
    private TitleBasicsEntity titleBasicsEntity;
}
