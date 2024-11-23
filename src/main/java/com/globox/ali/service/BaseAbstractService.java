package com.globox.ali.service;

import com.globox.ali.converter.BaseConverter;
import com.globox.ali.dto.BaseDto;
import com.globox.ali.entities.BaseEntity;
import com.globox.ali.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    public D save(D dto) {
        repository.save(converter.convertDto(dto));
        return dto;
    }

    public D update(D dto) {
        repository.save(converter.convertDto(dto));
        return dto;
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public D findById(ID id) {
        return converter.convertEntity(repository.findById(id).get());
    }

    public List<D> findAll(Integer pageNumber, Integer pageSize) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        List<E> eList = repository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).getContent();
        return converter.convertEntity(eList);
    }

    public List<D> findByExample(D dto) {
        E entity = converter.convertDto(dto);
        return converter.convertEntity(repository.findAll(Example.of(entity)));
    }

    public List<D> findAll(Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        List<E> eList = repository.findAll(Pageable.ofSize(10).withPage(pageNumber)).getContent();
        return converter.convertEntity(eList);
    }

    public List<D> findAllPageSize(Integer pageSize) {

        List<E> eList = repository.findAll(Pageable.ofSize(10).withPage(pageSize)).getContent();
        return converter.convertEntity(eList);
    }

    public List<D> findAll() {
        List<E> eList = repository.findAll(Pageable.ofSize(10).withPage(1)).getContent();
        return converter.convertEntity(eList);
    }
}
