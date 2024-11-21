package com.globox.ali.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VWDirectorsWritersSameDto extends BaseDto {

    private String tconst;
    private Integer endYear;
    private Boolean isAdult;
    private String originalTitle;
    private String primaryTitle;
    private Integer runtimeMinutes;
    private Integer startYear;
    private String titleType;
    private String idOfWriterOfMovie;
    private String idOfDirectorOfMovie;
    private String idOfWMovie;
    private String idOfDMovie;

}
