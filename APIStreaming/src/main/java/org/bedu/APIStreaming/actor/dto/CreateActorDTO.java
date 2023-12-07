package org.bedu.APIStreaming.actor.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateActorDTO {

    private String firstName;

    @NotBlank(message = "Please provide the actor last name")
    private String lastName;

}
