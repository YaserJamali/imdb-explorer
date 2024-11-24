
package com.globox.ali.controller;

import com.globox.ali.utils.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/input-to-tables")
@Tag(name = "InputDataToTableController", description = "APIs for importing data into tables")
@RequiredArgsConstructor
public class InputDataToTableController {

    private final NameBasicsInputService nameBasicsInputService;
    private final TitleBasicInputService titleBasicInputService;
    private final TitleCrewInputService titleCrewInputService;
    private final TitlePrincipalsInputService titlePrincipalsInputService;
    private final TitleRatingsInputService titleRatingsInputService;

    @PostMapping("/name-basic")
    @Operation(summary = "Insert Name Basic Data", description = "Imports name basic data into the database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Data imported successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void insertToNameBasic() throws IOException {
        nameBasicsInputService.importNameBasics();
    }

    @PostMapping("/title-basic")
    @Operation(summary = "Import Title Basic Data", description = "Imports title basic data into the database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Data imported successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void importTitleBasics() throws IOException {
        titleBasicInputService.importTitleBasics();
    }

    @PostMapping("/title-crew")
    @Operation(summary = "Import Title Crew Data", description = "Imports title crew data into the database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Data imported successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void importTitleCrew() throws IOException {
        titleCrewInputService.importTitleCrew();
    }

    @PostMapping("/title-principals")
    @Operation(summary = "Import Title Principals Data", description = "Imports title principals data into the database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Data imported successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void importTitlePrincipals() throws IOException {
        titlePrincipalsInputService.importTitlePrincipals();
    }

    @PostMapping("/title-ratings")
    @Operation(summary = "Import Title Ratings Data", description = "Imports title ratings data into the database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Data imported successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void importTitleRatings() throws IOException {
        titleRatingsInputService.importTitleRatings();
    }
}