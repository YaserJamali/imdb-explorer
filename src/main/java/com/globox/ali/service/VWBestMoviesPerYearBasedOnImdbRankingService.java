package com.globox.ali.service;

import com.globox.ali.dto.VWBestMoviesPerYearBasedOnImdbRankingDto;
import com.globox.ali.entities.VWBestMoviesPerYearBasedOnImdbRankingEntity;
import com.globox.ali.repository.VWBestMoviesPerYearBasedOnImdbRankingRepositoryImplI;
import org.springframework.stereotype.Service;

@Service
public class VWBestMoviesPerYearBasedOnImdbRankingService
        extends BaseImmutableAbstractService<VWBestMoviesPerYearBasedOnImdbRankingEntity, VWBestMoviesPerYearBasedOnImdbRankingDto, String, VWBestMoviesPerYearBasedOnImdbRankingRepositoryImplI> {
}