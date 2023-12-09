package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserDTO {

    @Schema(description = "Tu Nombre", example = "Esteban")
    @NotBlank(message = "Please provide your first name")
    private String firstName;

    @Schema(description = "Tu Apellido", example = "Lopez")
    @NotBlank(message = "Please provide your last name")
    private String lastName;

    @Schema(description = "Tu Correo electronico", example = "thunder@gmail.com")
    @Email(message = "A valid email is required")
    private String email;

}