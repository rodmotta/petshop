package com.github.rodmotta.petshop.dto.requests;

public record UserTokenRequest(
        String username,
        String password) {
}
