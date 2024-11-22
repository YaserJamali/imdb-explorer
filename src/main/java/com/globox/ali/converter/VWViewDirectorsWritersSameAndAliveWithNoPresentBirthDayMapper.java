package com.globox.ali.converter;

import com.globox.ali.dto.VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayDto;
import com.globox.ali.entities.VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayMapper
        extends BaseConverter<VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayDto, VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayEntity> {

}
