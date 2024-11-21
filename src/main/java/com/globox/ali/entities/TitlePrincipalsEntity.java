package com.globox.ali.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "TB_TITLE_PRINCIPALS")
@Getter
@Setter
@IdClass(TitlePrincipalsEntity.TitlePrincipalsId.class)
public class TitlePrincipalsEntity extends BaseEntity {
    @Id
    private String tconst;
    @Id
    private Integer ordering;
    private String nconst;
    private String category;
    private String job;
    private String characters;


    @Getter
    @Setter
    @EqualsAndHashCode
    public static class TitlePrincipalsId implements Serializable {
        private String tconst;
        private Integer ordering;

    }
}