package com.globox.ali.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_title_principals")
@Getter
@Setter
public class TitlePrincipalsEntity extends BaseEntity{
@Column(name = "MOVIE_ID")
    private String movieId;
    private String name;
    private String category;

    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private TitleBasicsEntity titleBasicsEntity;


}