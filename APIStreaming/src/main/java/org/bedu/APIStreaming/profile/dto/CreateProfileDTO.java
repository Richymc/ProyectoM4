package org.bedu.APIStreaming.profile.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProfileDTO {

    @NotBlank(message = "Please provide your name")
    private String name;

}
