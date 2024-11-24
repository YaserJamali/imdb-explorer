package com.globox.ali.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Details about the title ratings")
public class TitleRatingsDto extends BaseDto {

    @NotNull(message = "tconst cannot be null")
    @Size(min = 1, max = 10, message = "tconst must be between 1 and 10 characters")
    @Schema(description = "The unique identifier of the title")
    private String tconst;

    @NotNull(message = "averageRating cannot be null")
    @Min(value = 0, message = "averageRating must be at least 0")
    @Max(value = 10, message = "averageRating must be at most 10")
    @Schema(description = "The average rating of the title")
    private Double averageRating;

    @NotNull(message = "numVotes cannot be null")
    @Min(value = 0, message = "numVotes must be at least 0")
    @Schema(description = "The number of votes the title has received")
    private Integer numVotes;
}