package com.globox.ali.converter;

import com.globox.ali.dto.VWTitleWithTwoOrMoreSameCategoryDto;
import com.globox.ali.entities.VWTitleWithTwoOrMoreSameCategoryEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWTitleWithTwoOrMoreSameCategoryMapper
        extends BaseConverter<VWTitleWithTwoOrMoreSameCategoryDto, VWTitleWithTwoOrMoreSameCategoryEntity> {

}
