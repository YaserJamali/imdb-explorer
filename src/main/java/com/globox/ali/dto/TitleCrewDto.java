package com.globox.ali.dto;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TitleCrewDto", description = "Schema to hold Title Crew information")
public class TitleCrewDto extends BaseDto {

    @NotEmpty(message = "tconst cannot be null or empty")
    @Schema(description = "The unique identifier for the title", example = "tt0000001")
    private String tconst;

    @Schema(description = "List of directors for the title", example = "[\"Director1\", \"Director2\"]")
    private List<String> directors;

    @Schema(description = "List of writers for the title", example = "[\"Writer1\", \"Writer2\"]")
    private List<String> writers;
}
