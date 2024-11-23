package com.globox.ali.service;

import com.globox.ali.dto.VWTitleWithTwoOrMoreSameCategoryDto;
import com.globox.ali.entities.VWTitleWithTwoOrMoreSameCategoryEntity;
import com.globox.ali.repository.VWTitleWithTwoOrMoreSameCategoryRepositoryImplI;
import org.springframework.stereotype.Service;

@Service
public class VWTitleWithTwoOrMoreSameCategoryService
        extends BaseImmutableAbstractService<VWTitleWithTwoOrMoreSameCategoryEntity, VWTitleWithTwoOrMoreSameCategoryDto, String, VWTitleWithTwoOrMoreSameCategoryRepositoryImplI> {
}