package com.globox.ali.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VMDirectorsWritersSameAndAliveDto extends BaseDto {
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String nconst;
    private String primaryName;
    private Integer birthYear;
    private Integer deathYear;
}
