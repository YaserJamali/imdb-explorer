package com.globox.ali.converter;

import com.globox.ali.dto.TitleCrewDto;
import com.globox.ali.entities.TitleCrewEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface TitleCrewMapper extends BaseConverter<TitleCrewDto, TitleCrewEntity> {

}
