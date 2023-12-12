package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddMovieDTO {
    
    @Schema(description = "Identificador de la película a asociar", example = "10")
    private long movieId;
}
