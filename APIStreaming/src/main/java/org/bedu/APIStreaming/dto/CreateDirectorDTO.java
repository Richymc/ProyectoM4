package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDirectorDTO {

    @Schema(description = "Nombre del Director", example = "Jon")
    private String firstName;

    @Schema(description = "Apellido del Director", example = "Favreau")
    @NotBlank(message = "Please provide the director last name")
    private String lastName;
}
