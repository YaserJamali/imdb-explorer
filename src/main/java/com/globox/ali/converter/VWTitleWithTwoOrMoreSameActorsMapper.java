package com.globox.ali.converter;

import com.globox.ali.dto.VWTitleWithTwoOrMoreSameActorsDto;
import com.globox.ali.entities.VWTitleWithTwoOrMoreSameActorsEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWTitleWithTwoOrMoreSameActorsMapper
        extends BaseConverter<VWTitleWithTwoOrMoreSameActorsEntity, VWTitleWithTwoOrMoreSameActorsDto> {

}
