package com.globox.ali.service;

import com.globox.ali.entities.BaseEntity;
import com.globox.ali.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseAbstractService<E extends BaseEntity, R extends BaseRepository<E>> {

    @Autowired
    protected R repository;


    public E save(E entity) {
        return repository.save(entity);
    }

    public E update(E entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public E findById(String id) {
        return repository.findById(id).get();
    }

    public List<E> findAll(int pageNumber, int pageSize) {

        return repository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).getContent();
    }

    public List<E> findAll() {

        return repository.findAll();
    }

    public List<E> findByExample(E entity) {

        return repository.findAll(Example.of(entity));
    }
}
