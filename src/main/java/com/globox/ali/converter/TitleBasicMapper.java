package com.globox.ali.converter;

import com.globox.ali.dto.TitleBasicsDto;
import com.globox.ali.entities.TitleBasicsEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface TitleBasicMapper extends BaseConverter<TitleBasicsEntity, TitleBasicsDto> {

}
