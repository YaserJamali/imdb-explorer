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
@Schema(description = "Details about movies with the same director and writer who are alive")
public class VWSameDirectorWriterDto extends BaseDto {

    @NotNull(message = "tconst cannot be null")
    @Size(min = 1, max = 10, message = "tconst must be between 1 and 10 characters")
    @Schema(description = "The unique identifier of the title")
    private String tconst;

    @Schema(description = "The end year of the movie")
    private Integer endYear;

    @Schema(description = "Indicates if the movie is for adults")
    private Boolean isAdult;

    @Schema(description = "The original title of the movie")
    private String originalTitle;

    @Schema(description = "The primary title of the movie")
    private String primaryTitle;

    @Schema(description = "The runtime of the movie in minutes")
    private Integer runtimeMinutes;

    @Schema(description = "The start year of the movie")
    private Integer startYear;

    @Schema(description = "The type of the title")
    private String titleType;

    @NotNull(message = "nconst cannot be null")
    @Size(min = 1, max = 10, message = "nconst must be between 1 and 10 characters")
    @Schema(description = "The unique identifier of the name")
    private String nconst;

    @Schema(description = "The primary name of the director/writer")
    private String primaryName;

    @Schema(description = "The birth year of the director/writer")
    private Integer birthYear;

    @Schema(description = "The death year of the director/writer")
    private Integer deathYear;
}
