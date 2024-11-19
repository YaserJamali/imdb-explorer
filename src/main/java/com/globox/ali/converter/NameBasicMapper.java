package com.globox.ali.converter;

import com.globox.ali.dto.NameBasicsDto;
import com.globox.ali.entities.NameBasicsEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface NameBasicMapper extends BaseConverter<NameBasicsDto, NameBasicsEntity> {

}
