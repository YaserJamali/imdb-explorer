package com.globox.ali.converter;

import com.globox.ali.dto.VWBestGenresOfMoviesDto;
import com.globox.ali.entities.VWBestGenresOfMoviesEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWBestGenresOfMoviesMapper
        extends BaseConverter<VWBestGenresOfMoviesEntity, VWBestGenresOfMoviesDto> {

}
