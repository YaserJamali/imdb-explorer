package com.globox.ali.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_title_basics")
@Getter
@Setter
public class TitleBasicsEntity extends BaseEntity {
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String genres;

    @OneToMany(mappedBy = "titleBasicsEntity")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitleRatingsEntity> ratings;

    @OneToMany(mappedBy = "titleBasicsEntity")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitleCrewEntity> crew;

    @OneToMany(mappedBy = "titleBasicsEntity")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitlePrincipalsEntity> principals;
}