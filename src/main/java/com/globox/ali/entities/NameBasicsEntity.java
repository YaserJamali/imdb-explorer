package com.globox.ali.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "tb_name_basics")
@Getter
@Setter
public class NameBasicsEntity extends BaseEntity {
    @Column(name = "PRIMARY_NAME")
    private String primaryName;
    @Column(name = "BIRTH_YEAR")
    private Integer birthYear;
    @Column(name = "DEATH_YEAR")
    private Integer deathYear;
    @OneToMany(mappedBy = "actor")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitlePrincipalsEntity> actedTitles;
    @OneToMany(mappedBy = "director")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitleCrewEntity> directedTitles;
    @OneToMany(mappedBy = "writer")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<TitleCrewEntity> writtenTitles;
}


