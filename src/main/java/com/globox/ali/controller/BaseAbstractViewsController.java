package com.globox.ali.controller;

import com.globox.ali.dto.BaseDto;
import com.globox.ali.dto.ErrorResponseDto;
import com.globox.ali.entities.BaseEntity;
import com.globox.ali.service.BaseImmutableAbstractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/view")
@Tag(name = "BaseAbstractViewsController", description = "Base controller for view operations")
public abstract class BaseAbstractViewsController<E extends BaseEntity, D extends BaseDto, S extends BaseImmutableAbstractService<E, D, ID, ? extends JpaRepository<E, ID>>, ID extends Serializable> {

    @Autowired
    protected S service;

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
                    content = @Content
                            (schema = @Schema(implementation = ErrorResponseDto.class)))
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
