package com.globox.ali.repository;

import com.globox.ali.entities.VWCastTitleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VWCastTitleRepositoryImplI extends IBaseImmutableRepository<VWCastTitleEntity, String> {
    List<VWCastTitleEntity> findAllByPrimaryNameLike(String primaryName);
}
