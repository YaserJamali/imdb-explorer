package com.globox.ali.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tb_title_basics")
@Getter
@Setter
public class TitleBasicsEntity extends BaseEntity{
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