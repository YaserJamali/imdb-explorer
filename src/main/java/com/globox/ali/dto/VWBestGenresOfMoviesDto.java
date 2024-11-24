package com.globox.ali.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Details about the best genres of movies")
public class VWBestGenresOfMoviesDto extends BaseDto {

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

    @Schema(description = "The genres of the movie")
    private String genres;

    @Schema(description = "The average ratings of the movie")
    private Double averageRatings;

    @Schema(description = "The number of votes the movie has received")
    private Long numVotes;
}
