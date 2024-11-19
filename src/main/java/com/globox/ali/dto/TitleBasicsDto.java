package com.globox.ali.dto;


import com.globox.ali.entities.TitleCrewEntity;
import com.globox.ali.entities.TitlePrincipalsEntity;
import com.globox.ali.entities.TitleRatingsEntity;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleBasicsDto extends BaseDto {

    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String genres;
    private Set<TitleRatingsEntity> ratings;
    private Set<TitleCrewEntity> crew;
    private Set<TitlePrincipalsEntity> principals;
}