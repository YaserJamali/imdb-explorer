package com.globox.ali.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "NameBasicsDto", description = "Schema to hold Name Basics information")
public class NameBasicsDto extends BaseDto {

    @NotEmpty(message = "nconst cannot be null or empty")
    @Schema(description = "The unique identifier for the name", example = "nm0000001")
    private String nconst;

    @NotEmpty(message = "Primary name cannot be null or empty")
    @Size(min = 1, max = 100, message = "Primary name must be between 1 and 100 characters")
    @Schema(description = "The primary name of the person", example = "John Doe")
    private String primaryName;

    @Schema(description = "The birth year of the person", example = "1980")
    private Integer birthYear;
    private Integer deathYear;

    @Schema(description = "The primary professions of the person", example = "[\"Actor\", \"Director\"]")
    private List<String> primaryProfession;

    @Schema(description = "The titles the person is known for", example = "[\"tt0000001\", \"tt0000002\"]")
    private List<String> knownForTitles;
}

