package com.globox.ali.imdb.explorer.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_title_principals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitlePrincipalsEntity extends BaseAbstractEntity{


    private String movieId;
    private String name;
    private String category;

    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    private TitleBasicsEntity titleBasicsEntity;


}