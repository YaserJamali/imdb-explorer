package com.globox.ali.dto;


import com.globox.ali.entities.TitleBasicsEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TitleRatingsDto extends BaseDto {
    private float averageRating;
    private int numVotes;
    private TitleBasicsEntity titleBasicsEntity;

}