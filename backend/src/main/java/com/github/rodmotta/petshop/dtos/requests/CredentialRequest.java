package com.github.rodmotta.petshop.dtos.requests;

import jakarta.validation.constraints.NotBlank;

public record CredentialRequest(
        @NotBlank(message = "Can not be blank.")
        String username,
        @NotBlank(message = "Can not be blank.")
        String password) {
}
