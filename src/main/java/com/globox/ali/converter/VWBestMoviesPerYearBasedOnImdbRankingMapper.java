package com.globox.ali.converter;

import com.globox.ali.dto.VWBestMoviesPerYearBasedOnImdbRankingDto;
import com.globox.ali.entities.VWBestMoviesPerYearBasedOnImdbRankingEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface VWBestMoviesPerYearBasedOnImdbRankingMapper
        extends BaseConverter<VWBestMoviesPerYearBasedOnImdbRankingEntity, VWBestMoviesPerYearBasedOnImdbRankingDto> {

}
