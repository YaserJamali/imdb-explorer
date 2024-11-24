package com.globox.ali.controller;


import com.globox.ali.dto.ErrorResponseDto;
import com.globox.ali.dto.VWSameDirectorWriterDto;
import com.globox.ali.entities.VWSameDirectorWriterEntity;
import com.globox.ali.exceptions.ThereIsNoAliveSameDirectorAndWriterOnMovieException;
import com.globox.ali.service.VWSameDirectorWriterService;
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
@RequestMapping("/same-director-writer")
@Tag(name = "VWDirectorsWritersSameAndAliveWithNoPresentBirthDayController", description = "APIs related to Directors and Writers who are the Same and Alive without Present Birthday")
public class VWSameDirectorWriterController extends BaseAbstractViewsController<VWSameDirectorWriterEntity, VWSameDirectorWriterDto, VWSameDirectorWriterService, String> {

    @GetMapping("/alive-director-writer")
    @Operation(summary = "Find movies with alive directors and writers", description = "This API finds all movies where both the director and writer are alive.")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "204", description = "No Record Found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))})
    public ResponseEntity<List<VWSameDirectorWriterDto>> findAliveDirectorAndWriterForSameMovie(@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) throws ThereIsNoAliveSameDirectorAndWriterOnMovieException {
        return ResponseEntity.ok().body(service.findAliveDirectorAndWriterForSameMovie(pageNumber, pageSize));
    }

}
