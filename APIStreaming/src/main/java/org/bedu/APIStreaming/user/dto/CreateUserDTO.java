package org.bedu.APIStreaming.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserDTO {

    @NotBlank(message = "Please provide your first name")
    private String firstName;

    @NotBlank(message = "Please provide your last name")
    private String lastName;

    @Email(message = "A valid email is required")
    private String email;

}