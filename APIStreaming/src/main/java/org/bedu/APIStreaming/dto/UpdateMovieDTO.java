package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UpdateMovieDTO {
    
    @Schema(description = "Actualizacion del nombre de la pelicula")
    private String name;

    @Schema(description = "Actualizacion de la duracion de la pelicula")
    private long duration;

    @Schema(description = "Actualizacion de la descripcion de la pelicula")
    private String description;

    @Schema(description = "Actualizacion del genero de la pelicula")
    private String genre;
}
