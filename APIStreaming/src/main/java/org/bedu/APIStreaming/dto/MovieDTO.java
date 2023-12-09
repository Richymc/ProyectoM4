package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MovieDTO {
    
    @Schema(description = "Identificador de la Película", example = "30")
    private long id;

    @Schema(description = "Nombre de la Película", example = "Iron Man")
    private String name;
}
