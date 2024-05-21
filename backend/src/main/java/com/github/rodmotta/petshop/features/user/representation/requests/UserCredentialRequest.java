package com.github.rodmotta.petshop.features.user.representation.requests;

import jakarta.validation.constraints.NotBlank;

public record UserCredentialRequest(
        @NotBlank(message = "Can not be blank.")
        String username,
        @NotBlank(message = "Can not be blank.")
        String password) {
}
