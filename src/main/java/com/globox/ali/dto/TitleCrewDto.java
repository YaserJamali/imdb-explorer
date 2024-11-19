package com.globox.ali.dto;


import com.globox.ali.entities.TitleBasicsEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleCrewDto extends BaseDto {
    private String directors;
    private String writers;
    private TitleBasicsEntity titleBasicsEntity;
}