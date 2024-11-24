package com.globox.ali.service;

import com.globox.ali.dto.TitleBasicsDto;
import com.globox.ali.entities.TitleBasicsEntity;
import com.globox.ali.repository.TitleBasicsRepositoryImplI;
import org.springframework.stereotype.Service;

@Service
public class TitleBasicsService
        extends BaseAbstractService<TitleBasicsEntity, TitleBasicsDto, String, TitleBasicsRepositoryImplI> {
}
