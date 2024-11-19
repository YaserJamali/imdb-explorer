package com.globox.ali.dto;

import com.globox.ali.entities.NameBasicsEntity;
import com.globox.ali.entities.TitleBasicsEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class KnownForTitleDto extends BaseDto {
    private Long id;
    private NameBasicsEntity nameBasicsEntity;
    private TitleBasicsEntity titleBasicsEntity;
}
