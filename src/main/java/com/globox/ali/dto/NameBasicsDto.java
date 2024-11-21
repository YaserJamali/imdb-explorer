package com.globox.ali.dto;


import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NameBasicsDto extends BaseDto {
    private String nconst;
    private String primaryName;
    private Integer birthYear;
    private Integer deathYear;
    private List<String> primaryProfession;
    private List<String> knownForTitles;
}


