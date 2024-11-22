package com.globox.ali.repository;

import com.globox.ali.entities.VWTitleWithTwoOrMoreSameActorsEntity;
import com.globox.ali.entities.VWTitleWithTwoOrMoreSameCategoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface VWTitleWithTwoOrMoreSameActorsRepositoryImpl
        extends BaseRepository<VWTitleWithTwoOrMoreSameActorsEntity, String> {
}
