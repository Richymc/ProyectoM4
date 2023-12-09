package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDTO {

    @Schema(description = "Identificadror del Usuario", example = "50")
    private long id;

    @Schema(description = "Tu Nombre", example = "Esteban")
    private String firstName;

    @Schema(description = "Tu Apellido", example = "Lopez")
    private String lastName;

    @Schema(description = "Tu Correo Electronico", example = "thunder@gmail.com")
    private String email;
}