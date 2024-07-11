package com.github.rodmotta.petshop.dtos.requests;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        @NotBlank String street,
        @NotBlank String district,
        @NotBlank String city,
        @NotBlank String state,
        @NotBlank String zipcode) {
}
