package com.globox.ali.imdb.explorer.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tb_title_basics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleBasicsEntity extends BaseAbstractEntity{
    private String title;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String genres;

    @OneToMany(mappedBy = "titleBasicsEntity")
    private Set<TitleRatingsEntity> ratings;

    @OneToMany(mappedBy = "titleBasicsEntity")
    private Set<TitleCrewEntity> crew;

    @OneToMany(mappedBy = "titleBasicsEntity")
    private Set<TitlePrincipalsEntity> principals;
}