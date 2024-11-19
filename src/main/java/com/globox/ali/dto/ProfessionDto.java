package com.globox.ali.dto;

import com.globox.ali.entities.NameBasicsEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessionDto extends BaseDto {
    private Long id;
    private String profession;
    private NameBasicsEntity nameBasicsEntity;
}