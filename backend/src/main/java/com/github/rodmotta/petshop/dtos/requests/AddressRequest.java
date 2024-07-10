package com.github.rodmotta.petshop.dtos.requests;

public record AddressRequest(
        String street,
        String district,
        String city,
        String state,
        String zipcode) {
}
