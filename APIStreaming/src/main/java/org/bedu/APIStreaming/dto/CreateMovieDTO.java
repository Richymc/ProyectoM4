package org.bedu.APIStreaming.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateMovieDTO {
    
    @NotBlank (message = "Please provide the name of the movie.")
    private String nameMovie;

    @NotBlank(message = "Please provide the duration of the movie.")
    private Long duration;

    @NotBlank (message = "Please provide the description of the movie.")
    private String description;
    
    @NotBlank (message = "Please provide the genre of the movie.")
    private String genre;
}
