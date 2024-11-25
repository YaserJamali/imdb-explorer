package com.globox.ali.controller;


import com.globox.ali.dto.ErrorResponseDto;
import com.globox.ali.dto.VWCastTitleDto;
import com.globox.ali.entities.VWCastTitleEntity;
import com.globox.ali.exceptions.NoMovieExistsForTheesActors;
import com.globox.ali.exceptions.NoTitleHasBeenRegisteredException;
import com.globox.ali.service.VWCastTitleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/titles-of-casts")
@Tag(name = "VWTitleWithTwoOrMoreSameActorsController", description = "APIs related to Movies with Two or More Same Actors")
public class VWCastTitleController
        extends BaseAbstractViewsController<VWCastTitleEntity, VWCastTitleDto, VWCastTitleService, String> {

    @GetMapping("/movie-writer-director-alive")
    @Operation(summary = "Find all movies by category and primary names", description = "This API finds all movies by the specified category and primary names of two actors.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "404", description = "HTTP Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public ResponseEntity<List<VWCastTitleDto>> findAllByCategoryAndPrimaryName(
            @RequestParam(value="firstPrimaryName" ,defaultValue = "Brad Pitt", required = true) String firstPrimaryName,
            @RequestParam(value="secondPrimaryName" ,defaultValue = "george clooney", required = true) String secondPrimaryName)
            throws NoTitleHasBeenRegisteredException, NoMovieExistsForTheesActors {
        return ResponseEntity.ok().body(service.findAllByCategoryAndPrimaryName(firstPrimaryName, secondPrimaryName));
    }


}
