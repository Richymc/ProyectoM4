package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserDTO {

    @Schema(description = "Tu Nombre", example = "Esteban")
    @NotBlank(message = "Por favor ingresar el nombre del usuario.")
    private String firstName;

    @Schema(description = "Tu Apellido", example = "Lopez")
    @NotBlank(message = "Por favor ingresar el apellido del usuario.")
    private String lastName;

    @Schema(description = "Tu Correo electronico", example = "thunder@gmail.com")
    @NotBlank(message = "Por favor ingresar el correo electrónico del usuario.")
    @Email(message = "Favor de ingresar un correo electrónico válido.")
    private String email;

}