package com.github.rodmotta.petshop.commons.errors.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class ErrorResponse {
    private String message;
    private List<ValidationResponse> validations;
}
