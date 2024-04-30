package com.github.rodmotta.petshop.dto.requests;

public record UserRequest(
        String username,
        String password,
        String email,
        String firstName,
        String lastName) {
}
