package com.globox.ali.service;

import com.globox.ali.converter.BaseConverter;
import com.globox.ali.dto.BaseDto;
import com.globox.ali.entities.BaseEntity;
import com.globox.ali.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class BaseAbstractService<E extends BaseEntity, D extends BaseDto, ID extends Serializable, R extends IBaseRepository<E, ID>> {

    @Autowired
    protected R repository;

    private BaseConverter<E, D> converter;


    @CachePut(value = "entities", key = "#dto.id")
    public D save(D dto) {
        repository.save(converter.convertDto(dto));
        return dto;
    }

    @CachePut(value = "entities", key = "#dto.id")
    public D update(D dto) {
        repository.save(converter.convertDto(dto));
        return dto;
    }

    @CacheEvict(value = "entities", key = "#id")
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Cacheable(value = "entities", key = "#id")
    public D findById(ID id) {
        return converter.convertEntity(repository.findById(id).orElse(null));
    }

    @Cacheable(value = "entities")
    public List<D> findAll(Integer pageNumber, Integer pageSize) {

        List<E> eList = repository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).getContent();
        return converter.convertEntity(eList);
    }

    @Cacheable(value = "entities")
    public List<D> findByExample(D dto) {
        E entity = converter.convertDto(dto);
        return converter.convertEntity(repository.findAll(Example.of(entity)));
    }
}
