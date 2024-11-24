package com.globox.ali.converter;

import com.globox.ali.dto.VWSameDirectorWriterDto;
import com.globox.ali.entities.VWSameDirectorWriterEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWSameDirectorWriterMapper
        extends BaseConverter<VWSameDirectorWriterEntity, VWSameDirectorWriterDto> {

}
