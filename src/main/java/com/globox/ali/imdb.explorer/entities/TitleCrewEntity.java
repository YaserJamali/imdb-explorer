package com.globox.ali.imdb.explorer.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_title_crew")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleCrewEntity extends BaseAbstractEntity {
    private String directors;
    private String writers;

    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    private TitleBasicsEntity titleBasicsEntity;
}