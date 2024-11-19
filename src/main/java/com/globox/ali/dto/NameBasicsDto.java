package com.globox.ali.dto;


import com.globox.ali.entities.TitleCrewEntity;
import com.globox.ali.entities.TitlePrincipalsEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class NameBasicsDto extends BaseDto {
    private String primaryName;
    private Integer birthYear;
    private Integer deathYear;
    private Set<TitlePrincipalsEntity> actedTitles;
    private Set<TitleCrewEntity> directedTitles;
    private Set<TitleCrewEntity> writtenTitles;
}


