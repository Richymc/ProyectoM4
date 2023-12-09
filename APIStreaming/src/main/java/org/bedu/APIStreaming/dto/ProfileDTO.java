package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProfileDTO {

    @Schema(description = "Identificador del Perfil", example = "40")
    private long id;

    @Schema(description = "Nombre del Perfil", example = "Esteban")
    private String name;

}
