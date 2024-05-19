package com.github.rodmotta.petshop.features.user.dto.requests;

public record UserRequest(
        String username,
        String password,
        String email,
        String firstName,
        String lastName) {
}
