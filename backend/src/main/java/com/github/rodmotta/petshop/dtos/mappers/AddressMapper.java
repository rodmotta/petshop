package com.github.rodmotta.petshop.dtos.mappers;

import com.github.rodmotta.petshop.v2.adapters.rest.request.AddressRequest;
import com.github.rodmotta.petshop.dtos.responses.AddressResponse;
import com.github.rodmotta.petshop.dtos.responses.ViaCEPResponse;
import com.github.rodmotta.petshop.v2.adapters.persistence.entity.AddressEntity;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class AddressMapper {

    public static AddressResponse addressEntityToResponse(AddressEntity addressEntity) {
        return new AddressResponse(
                addressEntity.getId(),
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getDistrict(),
                addressEntity.getCity(),
                addressEntity.getState(),
                addressEntity.getZipCode());
    }

    public static AddressResponse viaCEPResponseToResponse(ViaCEPResponse viaCEPResponse) {
        return new AddressResponse(
                null,
                viaCEPResponse.logradouro(),
                null,
                viaCEPResponse.bairro(),
                viaCEPResponse.localidade(),
                viaCEPResponse.uf(),
                viaCEPResponse.cep().replace("-", ""));
    }

    public static AddressEntity addressRequestToEntity(AddressRequest addressRequest, UUID customerId) {
        return AddressEntity.builder()
                .street(addressRequest.street())
                .number(addressRequest.number())
                .district(addressRequest.district())
                .city(addressRequest.city())
                .state(addressRequest.state())
                .zipCode(addressRequest.zipcode())
                .customerId(customerId)
                .build();
    }
}
