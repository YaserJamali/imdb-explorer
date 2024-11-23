package com.globox.ali.converter;

import com.globox.ali.dto.VWDirectorsWritersSameAndAliveWithNoPresentBirthDayDto;
import com.globox.ali.entities.VWDirectorsWritersSameAndAliveWithNoPresentBirthDayEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWDirectorsWritersSameAndAliveWithNoPresentBirthDayMapper
        extends BaseConverter<VWDirectorsWritersSameAndAliveWithNoPresentBirthDayEntity, VWDirectorsWritersSameAndAliveWithNoPresentBirthDayDto> {

}
