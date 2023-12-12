package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MovieDTO {
    
    @Schema(description = "Identificador de la película", example = "30")
    private long id;

    @Schema(description = "Nombre de la película", example = "Iron Man")
    private String name;
    @Schema(description = "Duración de la película", example = "120")
    private long duration;
    private String description;
    private String genre;
}
