package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateMovieDTO {
    
    @Schema(description = "Nombre de la Película", example = "Iron Man")
    @NotBlank (message = "Please provide the name of the movie.")
    private String name;

    @Schema(description = "Duración de la película", example = "120")
    @NotNull
    @Positive
    private long duration;

    @Schema(description = "Descripción de la película", example = "Es una película de superhéroes de 2008. Es la primera entrega del Universo cinematográfico de Marvel")
    @NotBlank (message = "Please provide the description of the movie.")
    private String description;
    
    @Schema(description = "Género de la película", example = "Acción")
    @NotBlank (message = "Please provide the genre of the movie.")
    private String genre;
}
