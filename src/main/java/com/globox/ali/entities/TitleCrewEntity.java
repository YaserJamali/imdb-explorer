package com.globox.ali.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_title_crew")
@Getter
@Setter
public class TitleCrewEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private NameBasicsEntity director;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private NameBasicsEntity writer;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private TitleBasicsEntity titleBasicsEntity;
}