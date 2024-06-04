package com.github.rodmotta.petshop.features.customer.representation.response;

import java.util.UUID;

public record AddressResponse(
        UUID id,
        String street,
        String city,
        String state,
        String zip) {
}
