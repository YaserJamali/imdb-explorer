package com.globox.ali.controller;

import com.globox.ali.dto.BaseDto;
import com.globox.ali.dto.ErrorResponseDto;
import com.globox.ali.entities.BaseEntity;
import com.globox.ali.service.BaseAbstractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/table")
@Tag(name = "BaseAbstractController", description = "Base controller for common CRUD operations")
public abstract class BaseAbstractController<E extends BaseEntity, D extends BaseDto, ID extends Serializable> {

    @Autowired
    protected BaseAbstractService<E, D, ID, ? extends JpaRepository<E, ID>> service;

    @PostMapping("/save")
    @Transactional
    @Operation(summary = "Save a new entity", description = "This API saves a new entity.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public D save(@RequestBody D d) {
        return service.save(d);
    }

    @PutMapping("/update")
    @Transactional
    @Operation(summary = "Update an existing entity", description = "This API updates an existing entity.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public D update(@RequestBody D d) {
        return service.update(d);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    @Operation(summary = "Delete an entity by ID", description = "This API deletes an entity by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "404", description = "HTTP Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public void deleteById(@PathVariable ID id) {
        service.deleteById(id);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "Find an entity by ID", description = "This API finds an entity by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "404", description = "HTTP Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public D findById(@PathVariable ID id) {
        return service.findById(id);
    }

    @GetMapping("/find-all")
    @Operation(summary = "Find all entities", description = "This API finds all entities with pagination.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public List<D> findAll(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return service.findAll(pageNumber, pageSize);
    }

    @PostMapping("/find")
    @Operation(summary = "Find entities by example", description = "This API finds entities by example.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public List<D> findByExample(@RequestBody D example) {
        return service.findByExample(example);
    }
}
