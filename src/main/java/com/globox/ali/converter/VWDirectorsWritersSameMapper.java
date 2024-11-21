package com.globox.ali.converter;

import com.globox.ali.dto.VWDirectorsWritersSameDto;
import com.globox.ali.entities.VWDirectorsWritersSameEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWDirectorsWritersSameMapper extends BaseConverter<VWDirectorsWritersSameDto, VWDirectorsWritersSameEntity> {

}
