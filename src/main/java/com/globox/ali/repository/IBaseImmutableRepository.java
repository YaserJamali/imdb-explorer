package com.globox.ali.repository;

import com.globox.ali.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IBaseImmutableRepository<E extends BaseEntity,ID extends Serializable> extends JpaRepository<E, ID> {
}
