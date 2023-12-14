package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddMovieDTO {
    
    @Schema(description = "Identificador de la película a asociar", example = "10")
    @NotNull
    @Positive
    private long movieId;
}
