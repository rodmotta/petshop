package com.github.rodmotta.petshop.v2.adapters.rest.request;

import com.github.rodmotta.petshop.v2.core.address.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressRequest(
        @NotBlank String street,
        @NotNull Integer number,
        @NotBlank String district,
        @NotBlank String city,
        @NotBlank String state,
        @NotBlank String zipcode) {
}
