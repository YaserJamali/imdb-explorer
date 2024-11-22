package com.globox.ali.converter;

import com.globox.ali.dto.VWDirectorsWritersSameAndAliveDto;
import com.globox.ali.entities.VWMDirectorsWritersSameAndAliveEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWDirectorsWritersSameAndAliveMapper extends BaseConverter<VWDirectorsWritersSameAndAliveDto, VWMDirectorsWritersSameAndAliveEntity> {

}
