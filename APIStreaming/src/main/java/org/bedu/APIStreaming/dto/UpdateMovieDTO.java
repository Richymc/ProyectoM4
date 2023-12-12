package org.bedu.APIStreaming.dto;

import lombok.Data;

@Data
public class UpdateMovieDTO {
    
    private String nameMovie;

    private long duration;

    private String description;

    private String genre;
}
