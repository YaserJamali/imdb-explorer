package com.globox.ali.converter;

import com.globox.ali.dto.VWCastTitleDto;
import com.globox.ali.entities.VWCastTitleEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWCastTitleMapper
        extends BaseConverter<VWCastTitleEntity, VWCastTitleDto> {

}
