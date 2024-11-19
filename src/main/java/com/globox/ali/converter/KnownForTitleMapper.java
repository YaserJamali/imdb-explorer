package com.globox.ali.converter;

import com.globox.ali.dto.KnownForTitleDto;
import com.globox.ali.entities.KnownForTitleEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface KnownForTitleMapper extends BaseConverter<KnownForTitleDto, KnownForTitleEntity> {

}
