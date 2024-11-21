package com.globox.ali.entities;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_title_crew")
@Getter
@Setter
public class TitleCrewEntity extends BaseEntity {
    @Id
    private String tconst;
    @ElementCollection
    private List<String> directors;
    @ElementCollection
    private List<String> writers;
}