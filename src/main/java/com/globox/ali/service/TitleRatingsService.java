package com.globox.ali.service;

import com.globox.ali.dto.TitleRatingsDto;
import com.globox.ali.entities.TitleRatingsEntity;
import com.globox.ali.repository.TitleRatingsRepositoryImplI;
import org.springframework.stereotype.Service;

@Service
public class TitleRatingsService extends BaseAbstractService<TitleRatingsEntity, TitleRatingsDto, String, TitleRatingsRepositoryImplI> {
}