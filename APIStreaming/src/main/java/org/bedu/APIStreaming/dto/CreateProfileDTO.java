package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProfileDTO {

    @Schema(description = "Nombre del perfil", example = "Esteban")
    @NotBlank(message = "Please provide your name")
    private String name;

}
