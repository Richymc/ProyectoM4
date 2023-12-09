package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateActorDTO {

    @Schema(description = "Nombre del Actor", example = "Robert")
    private String firstName;

    @Schema(description = "Apellido del Actor", example = "Downey Jr")
    @NotBlank(message = "Please provide the actor last name")
    private String lastName;

}
