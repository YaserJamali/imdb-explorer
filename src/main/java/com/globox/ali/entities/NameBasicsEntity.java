package com.globox.ali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "tb_name_basics")
@Getter
@Setter
public class NameBasicsEntity extends BaseEntity {
    @Id
    private String nconst;
    @Column(name = "PRIMARY_NAME")
    private String primaryName;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "DEATH_YEAR")
    private Integer deathYear;
    @ElementCollection
    private List<String> primaryProfession;
    @ElementCollection
    private List<String> knownForTitles;
}



