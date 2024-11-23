package com.globox.ali.service;

import com.globox.ali.dto.VWTitleWithTwoOrMoreSameActorsDto;
import com.globox.ali.entities.VWTitleWithTwoOrMoreSameActorsEntity;
import com.globox.ali.repository.VWTitleWithTwoOrMoreSameActorsRepositoryImplI;
import org.springframework.stereotype.Service;

@Service
public class VWTitleWithTwoOrMoreSameActorsService
        extends BaseImmutableAbstractService<VWTitleWithTwoOrMoreSameActorsEntity, VWTitleWithTwoOrMoreSameActorsDto, String, VWTitleWithTwoOrMoreSameActorsRepositoryImplI> {
}