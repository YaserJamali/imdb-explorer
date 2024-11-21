package com.globox.ali.converter;

import com.globox.ali.dto.VMDirectorsWritersSameAndAliveDto;
import com.globox.ali.entities.VMDirectorsWritersSameAndAliveEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWDirectorsWritersSameAndAliveMapper extends BaseConverter<VMDirectorsWritersSameAndAliveDto, VMDirectorsWritersSameAndAliveEntity> {

}
