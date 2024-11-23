package com.globox.ali.service;

import com.globox.ali.dto.VWCastTitleDto;
import com.globox.ali.entities.VWCastTitleEntity;
import com.globox.ali.repository.VWCastTitleRepositoryImplI;
import org.springframework.stereotype.Service;

@Service
public class VWCastTitleService
        extends BaseImmutableAbstractService<VWCastTitleEntity, VWCastTitleDto, String, VWCastTitleRepositoryImplI> {
}