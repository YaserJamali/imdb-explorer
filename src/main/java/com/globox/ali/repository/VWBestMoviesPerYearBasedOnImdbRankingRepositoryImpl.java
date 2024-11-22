package com.globox.ali.repository;

import com.globox.ali.entities.VWBestMoviesPerYearBasedOnImdbRankingEntity;
import com.globox.ali.entities.VWDirectorsWritersSameEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface VWBestMoviesPerYearBasedOnImdbRankingRepositoryImpl
        extends BaseRepository<VWBestMoviesPerYearBasedOnImdbRankingEntity, String> {
}
