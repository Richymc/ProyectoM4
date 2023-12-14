package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProfileDTO {

    @Schema(description = "Nombre del perfil", example = "Esteban")
    @NotBlank(message = "Por favor ingresar el nombre del perfil")
    private String name;

}
