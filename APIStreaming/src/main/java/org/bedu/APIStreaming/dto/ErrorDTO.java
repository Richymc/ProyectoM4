package org.bedu.APIStreaming.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    
    private String code;
    private String message;
    private Object details;
}
