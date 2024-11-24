package com.globox.ali.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Details about the cast and title")
public class VWCastTitleDto extends BaseDto {

    @NotNull(message = "tconst cannot be null")
    @Size(min = 1, max = 10, message = "tconst must be between 1 and 10 characters")
    @Schema(description = "The unique identifier of the title")
    private String tconst;

    @NotNull(message = "nconst cannot be null")
    @Size(min = 1, max = 10, message = "nconst must be between 1 and 10 characters")
    @Schema(description = "The unique identifier of the name")
    private String nconst;

    @Schema(description = "The category of the cast member")
    private String category;

    @Schema(description = "The primary title of the movie or show")
    private String primaryTitle;

    @Schema(description = "The original title of the movie or show")
    private String originalTitle;

    @Schema(description = "The start year of the movie or show")
    private Integer startYear;

    @Schema(description = "The end year of the movie or show")
    private Integer endYear;

    @Schema(description = "The runtime of the movie or show in minutes")
    private Integer runtimeMinutes;

    @Schema(description = "The type of the title")
    private String titleType;

    @Schema(description = "The primary name of the cast member")
    private String primaryName;
}
