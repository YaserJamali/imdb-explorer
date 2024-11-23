package com.globox.ali.controller;

import com.globox.ali.dto.BaseDto;
import com.globox.ali.entities.BaseEntity;
import com.globox.ali.service.BaseImmutableAbstractService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
@Transactional(readOnly = true)
@Validated
@Slf4j
public abstract class BaseAbstractViewsController<E extends BaseEntity, D extends BaseDto, ID extends Serializable> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseAbstractViewsController.class);

    @Autowired(required = true)
    protected BaseImmutableAbstractService<E, D, ID, ? extends JpaRepository<E, ID>> service;


    @GetMapping("/find/{id}")
    public D findById(@PathVariable ID id) {
        return service.findById(id);
    }


    @GetMapping("/find-all/{pageNumber}")
    public List<D> findAll(
            @PathParam("pageNumber") Integer pageNumber) {
        return service.findAll(pageNumber);
    }

    @GetMapping("/find-all/{pageSize}")
    public List<D> findAllPageSize(
            @PathParam("pageNumber") Integer pageNumber) {
        return service.findAllPageSize(pageNumber);
    }

    @GetMapping("/find-all/{pageNumber}/{pageSize}")
    public List<D> findAll(
            @PathParam("pageNumber") Integer pageNumber,
            @PathParam("pageSize") Integer pageSize
    ) {
        return service.findAll(pageNumber, pageSize);
    }

    @GetMapping("/find-all")
    public List<D> findAll() {
        return service.findAll();
    }

    @PostMapping("/find")
    public List<D> findByExample(@RequestBody D example) {
        return service.findByExample(example);
    }
}