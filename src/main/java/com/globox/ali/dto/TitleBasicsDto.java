package com.globox.ali.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TitleBasicsDto", description = "Schema to hold Title Basics information")
public class TitleBasicsDto extends BaseDto {

    @NotEmpty(message = "tconst cannot be null or empty")
    @Schema(description = "The unique identifier for the title", example = "tt0000001")
    private String tconst;

    @NotEmpty(message = "Title type cannot be null or empty")
    @Schema(description = "The type of the title", example = "movie")
    private String titleType;

    @NotEmpty(message = "Primary title cannot be null or empty")
    @Schema(description = "The primary title of the movie", example = "The Great Movie")
    private String primaryTitle;

    @NotEmpty(message = "Original title cannot be null or empty")
    @Schema(description = "The original title of the movie", example = "Le Grand Film")
    private String originalTitle;

    @Schema(description = "Indicates if the title is for adults", example = "false")
    private boolean isAdult;

    @Positive(message = "Start year must be a positive number")
    @Schema(description = "The start year of the title", example = "1990")
    private Integer startYear;

    @Positive(message = "End year must be a positive number")
    @Schema(description = "The end year of the title", example = "2000")
    private Integer endYear;

    @Positive(message = "Runtime minutes must be a positive number")
    @Schema(description = "The runtime of the title in minutes", example = "120")
    private Integer runtimeMinutes;

    @Schema(description = "The genres of the title", example = "[\"Drama\", \"Action\"]")
    private List<String> genres;
}
