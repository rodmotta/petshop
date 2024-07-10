package com.github.rodmotta.petshop.dtos.responses;

import java.util.UUID;

public record AddressResponse(
        UUID id,
        String street,
        String district,
        String city,
        String state,
        String zipcode) {
}
