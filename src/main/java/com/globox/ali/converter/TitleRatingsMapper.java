package com.globox.ali.converter;

import com.globox.ali.dto.TitleRatingsDto;
import com.globox.ali.entities.TitleRatingsEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface TitleRatingsMapper extends BaseConverter<TitleRatingsDto, TitleRatingsEntity> {

}
