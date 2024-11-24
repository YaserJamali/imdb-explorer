package com.globox.ali.service;

import com.globox.ali.dto.VWSameDirectorWriterDto;
import com.globox.ali.entities.VWSameDirectorWriterEntity;
import com.globox.ali.repository.VWSameDirectorWriterImpl;
import org.springframework.stereotype.Service;

@Service
public class VWSameDirectorWriterService
        extends BaseImmutableAbstractService<VWSameDirectorWriterEntity, VWSameDirectorWriterDto, String, VWSameDirectorWriterImpl> {
}