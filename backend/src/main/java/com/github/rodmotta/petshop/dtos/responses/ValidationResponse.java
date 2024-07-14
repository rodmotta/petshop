package com.github.rodmotta.petshop.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationResponse {
    private String field;
    private String message;
}