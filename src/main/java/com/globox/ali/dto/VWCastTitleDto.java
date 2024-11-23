package com.globox.ali.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VWCastTitleDto extends BaseDto {
    private String tconst;
    private String nconst;
    private String category;
    private String primaryTitle;
    private String originalTitle;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String titleType;
    private String primaryName;
}
