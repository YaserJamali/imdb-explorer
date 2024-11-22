package com.globox.ali.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VWDirectorsWritersSameAndAliveWithNoPresentBirthDayDto extends BaseDto {

    private String tconst;
    private Integer endYear;
    private Boolean isAdult;
    private String originalTitle;
    private String primaryTitle;
    private Integer runtimeMinutes;
    private Integer startYear;
    private String titleType;
    private String nconst;
    private String primaryName;
    private Integer birthYear;
    private Integer deathYear;
}
