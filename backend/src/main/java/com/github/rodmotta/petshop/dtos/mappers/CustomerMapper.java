package com.github.rodmotta.petshop.dtos.mappers;

import com.github.rodmotta.petshop.dtos.requests.CreateUserRequest;
import com.github.rodmotta.petshop.dtos.responses.AddressResponse;
import com.github.rodmotta.petshop.dtos.responses.CustomerResponse;
import com.github.rodmotta.petshop.persistence.entities.AddressEntity;
import com.github.rodmotta.petshop.persistence.entities.CustomerEntity;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CustomerMapper {

    public static CustomerResponse entityToResponse(CustomerEntity customerEntity) {
        return new CustomerResponse(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getEmail(),
                customerEntity.getAddresses().stream()
                        .map(CustomerMapper::addressEntityToResponse)
                        .toList()
        );
    }

    private static AddressResponse addressEntityToResponse(AddressEntity addressEntity) {
        return new AddressResponse(
                addressEntity.getId(),
                addressEntity.getAddress(),
                addressEntity.getCity(),
                addressEntity.getState(),
                addressEntity.getZipCode()
        );
    }

    public static CustomerEntity userRequestToCustomerEntity(UUID id, CreateUserRequest createUserRequest) {
        return CustomerEntity.builder()
                .id(id)
                .username(createUserRequest.username())
                .firstName(createUserRequest.firstName())
                .lastName(createUserRequest.lastName())
                .email(createUserRequest.email())
                .build();
    }
}
