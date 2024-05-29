package com.github.rodmotta.petshop.features.user.representation.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank(message = "Can not be blank.")
        String username,
        @NotBlank(message = "Can not be blank.")
        String password,
        @NotBlank(message = "Can not be blank.")
        @Email(message = "Invalid email.")
        String email,
        @NotBlank(message = "Can not be blank.")
        String firstName,
        @NotBlank(message = "Can not be blank.")
        String lastName) {
}
