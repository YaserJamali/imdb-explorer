package com.globox.ali.controller;


import com.globox.ali.dto.ErrorResponseDto;
import com.globox.ali.dto.VWBestGenresOfMoviesDto;
import com.globox.ali.entities.VWBestGenresOfMoviesEntity;
import com.globox.ali.service.VWBestGenresOfMoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/best-movies-of-the-year")
@Tag(name = "VWBestMoviesPerYearBasedOnImdbRankingController", description = "APIs related to Best Movies of the Year Based on IMDb Ranking")
public class VWBestGenresOfMoviesController
        extends BaseAbstractViewsController<VWBestGenresOfMoviesEntity, VWBestGenresOfMoviesDto, VWBestGenresOfMoviesService, String> {


    @GetMapping("/genre/{genre}")
    @Operation(summary = "Find all movies by genre", description = "This API finds all movies by the specified genre.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "404", description = "HTTP Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public List<VWBestGenresOfMoviesDto> findAllByGenres(
            @PathVariable @NotBlank String genre,
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return service.findAllByGenres(genre, pageNumber, pageSize);
    }
}