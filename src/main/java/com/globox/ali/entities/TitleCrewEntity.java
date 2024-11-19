package com.globox.ali.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_title_crew")
@Getter
@Setter
public class TitleCrewEntity extends BaseEntity {
    private String directors;
    private String writers;
    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private TitleBasicsEntity titleBasicsEntity;
}