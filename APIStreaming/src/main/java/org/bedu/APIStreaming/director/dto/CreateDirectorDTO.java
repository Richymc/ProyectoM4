package org.bedu.APIStreaming.director.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDirectorDTO {

    private String firstName;

    @NotBlank(message = "Please provide the director last name")
    private String lastName;
}
