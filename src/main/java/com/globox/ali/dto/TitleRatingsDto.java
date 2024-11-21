package com.globox.ali.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleRatingsDto extends BaseDto {
    private String tconst;
    private Double averageRating;
    private Integer numVotes;
}