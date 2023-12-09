package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DirectorDTO {

    @Schema(description = "Identificador del Director", example = "20")
    private long id;

    @Schema(description = "Nombre del Director", example = "Jon")
    private String firstName;

    @Schema(description = "Apellido del Director", example = "Favreau")
    private String lastName;
}
