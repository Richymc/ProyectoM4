package org.bedu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateMovieDTO {
    
    @Schema(description = "Nombre de la Película", example = "Iron Man")
    @NotBlank (message = "Por favor ingresar el nombre de la película")
    private String name;

    @Schema(description = "Duración de la película", example = "120")
    @NotNull
    @Positive
    private long duration;

    @Schema(description = "Descripción de la película", example = "Es una película de superhéroes de 2008. Es la primera entrega del Universo cinematográfico de Marvel")
    @NotBlank (message = "Por favor ingrese una descripción de la película")
    private String description;
    
    @Schema(description = "Género de la película", example = "Acción")
    @NotBlank (message = "Por favor ingrese un género de película")
    private String genre;
}
