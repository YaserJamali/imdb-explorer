package com.globox.ali.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleCrewDto extends BaseDto {
    private String tconst;
    private List<String> directors;
    private List<String> writers;
}