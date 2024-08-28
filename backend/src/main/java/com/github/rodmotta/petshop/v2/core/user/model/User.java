package com.github.rodmotta.petshop.v2.core.user.model;

import com.github.rodmotta.petshop.v2.core.shared.enums.Role;

import java.util.UUID;

public record User(UUID id, String fistName, String lastName, String email, String username, String password, Role role) {
}
