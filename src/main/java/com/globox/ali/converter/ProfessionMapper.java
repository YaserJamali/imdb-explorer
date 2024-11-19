package com.globox.ali.converter;

import com.globox.ali.dto.ProfessionDto;
import com.globox.ali.dto.TitleRatingsDto;
import com.globox.ali.entities.ProfessionEntity;
import com.globox.ali.entities.TitleRatingsEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface ProfessionMapper extends BaseConverter<ProfessionDto, ProfessionEntity> {

}
