package com.globox.ali.repository;

import com.globox.ali.entities.VWSameDirectorWriterEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VWSameDirectorWriterImpl extends IBaseImmutableRepository<VWSameDirectorWriterEntity, String> {
    List<VWSameDirectorWriterEntity> findAllByDeathYearIsNull(Pageable pageable);
}
