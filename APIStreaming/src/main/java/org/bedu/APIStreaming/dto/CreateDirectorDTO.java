package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDirectorDTO {

    @Schema(description = "Nombre del Director", example = "Jon")
    @NotBlank(message = "Por favor ingresar el nombre del director.")
    private String firstName;

    @Schema(description = "Apellido del Director", example = "Favreau")
    @NotBlank(message = "Por favor ingresar el apellido del director.")
    private String lastName;
}
