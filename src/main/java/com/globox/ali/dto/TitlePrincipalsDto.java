package com.globox.ali.dto;


import com.globox.ali.entities.TitleBasicsEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitlePrincipalsDto extends BaseDto {
    private String movieId;
    private String name;
    private String category;
    private TitleBasicsEntity titleBasicsEntity;


}