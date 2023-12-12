package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateMovieDTO {
    
    @Schema(description = "Nombre de la Película", example = "Iron Man")
    @NotBlank (message = "Please provide the name of the movie.")
    private String nameMovie;

    @Schema(description = "Duracion de la pelicula", example = "120")
    @NotBlank(message = "Please provide the duration of the movie.")
    private long duration;

    @Schema(description = "Descripcion de la pelicula", example = "Es una película de superhéroes de 2008. Es la primera entrega del Universo cinematográfico de Marvel")
    @NotBlank (message = "Please provide the description of the movie.")
    private String description;
    
    @Schema(description = "Genero de la Película", example = "Acción")
    @NotBlank (message = "Please provide the genre of the movie.")
    private String genre;
}
