package com.globox.ali.dto;


import com.globox.ali.entities.TitleBasicsEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TitlePrincipalsDto extends BaseDto {
    private Long id;
    private String movieId;
    private String name;
    private String category;
    private TitleBasicsEntity titleBasicsEntity;


}