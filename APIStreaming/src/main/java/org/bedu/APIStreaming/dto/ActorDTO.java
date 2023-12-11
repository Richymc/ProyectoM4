package org.bedu.APIStreaming.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ActorDTO {

    @Schema(description = "Idenficador del Actor", example = "1")
    private long id;

    @Schema(description = "Nombre del Actor", example = "Robert")
    private String firstName;

    @Schema(description = "Apellido del Actor", example = "Downey Jr")
    private String lastName;
}
