package com.globox.ali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;




@Entity
@Table(name = "tb_name_basics")
@Getter
@Setter
public class NameBasicsEntity extends BaseEntity {
    @Id
    @Column(name = "nconst")
    private String nconst;

    @Column(name = "primary_name")
    private String primaryName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @OneToMany(mappedBy = "nameBasicsEntity")
    private Set<ProfessionEntity> professions;

    @OneToMany(mappedBy = "nameBasicsEntity")
    private Set<KnownForTitleEntity> knownForTitles;

    @OneToMany(mappedBy = "director")
    private Set<TitleCrewEntity> directedTitles;

    @OneToMany(mappedBy = "writer")
    private Set<TitleCrewEntity> writtenTitles;

    @OneToMany(mappedBy = "actor")
    private Set<TitlePrincipalsEntity> actedTitles;
}


