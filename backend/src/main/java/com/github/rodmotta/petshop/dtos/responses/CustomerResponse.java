package com.github.rodmotta.petshop.dtos.responses;

import java.util.List;
import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        List<AddressResponse> addresses) {
}
