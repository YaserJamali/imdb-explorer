package com.globox.ali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Entity
@Table(name = "tb_professions")
@Getter
@Setter
public class ProfessionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profession")
    private String profession;

    @ManyToOne
    @JoinColumn(name = "nconst")
    private NameBasicsEntity nameBasicsEntity;
}