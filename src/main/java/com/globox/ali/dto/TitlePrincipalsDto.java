package com.globox.ali.dto;


import lombok.*;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TitlePrincipalsDto", description = "Schema to hold Title Principals information")
public class TitlePrincipalsDto extends BaseDto {

    @NotEmpty(message = "tconst cannot be null or empty")
    @Schema(description = "The unique identifier for the title", example = "tt0000001")
    private String tconst;

    @Positive(message = "Ordering must be a positive number")
    @Schema(description = "The ordering of the principal cast/crew", example = "1")
    private Integer ordering;

    @NotEmpty(message = "nconst cannot be null or empty")
    @Schema(description = "The unique identifier for the name", example = "nm0000001")
    private String nconst;

    @NotEmpty(message = "Category cannot be null or empty")
    @Schema(description = "The category of the principal (e.g., actor, director)", example = "actor")
    private String category;

    @Schema(description = "The job of the principal in the title", example = "Director")
    private String job;

    @Schema(description = "The characters played by the principal", example = "['Character1', 'Character2']")
    private String characters;
}
