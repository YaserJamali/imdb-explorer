package com.globox.ali.converter;

import com.globox.ali.dto.TitlePrincipalsDto;
import com.globox.ali.entities.TitlePrincipalsEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface TitlePrincipalsMapper extends BaseConverter<TitlePrincipalsEntity, TitlePrincipalsDto> {

}
