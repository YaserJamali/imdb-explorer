package com.globox.ali.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_title_crew")
@Getter
@Setter

public class TitleCrewEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "DIRECTOR_ID")
    private NameBasicsEntity director;
    @ManyToOne
    @JoinColumn(name = "WRITER_ID")
    private NameBasicsEntity writer;
    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private TitleBasicsEntity titleBasicsEntity;
}