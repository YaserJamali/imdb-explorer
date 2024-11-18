package com.globox.ali.imdb.explorer.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseAbstractEntity {
    @Id
    private String tconst;
}
