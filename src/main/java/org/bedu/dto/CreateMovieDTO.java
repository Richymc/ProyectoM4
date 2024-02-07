package org.bedu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateMovieDTO {
    
    @Schema(description = "Nombre de la Película", example = "Iron Man")
    @NotBlank (message = "Por favor ingresar el nombre de la pelicula")
    private String name;

    @Schema(description = "Duración de la pelicula", example = "120")
    @NotNull
    @Positive
    private long duration;

    @Schema(description = "Descripción de la pelicula", example = "Es una película de superhéroes de 2008. Es la primera entrega del Universo cinematográfico de Marvel")
    @NotBlank (message = "Por favor ingrese una descripcion de la pelicula")
    private String description;
    
    @Schema(description = "Género de la película", example = "Acción")
    @NotBlank (message = "Por favor ingrese un genero de pelicula")
    private String genre;
}
