package com.github.rodmotta.petshop.features.customer.mapper;

import com.github.rodmotta.petshop.features.customer.entities.AddressEntity;
import com.github.rodmotta.petshop.features.customer.entities.CustomerEntity;
import com.github.rodmotta.petshop.features.customer.representation.response.AddressResponse;
import com.github.rodmotta.petshop.features.customer.representation.response.CustomerResponse;
import com.github.rodmotta.petshop.features.user.representation.request.CreateUserRequest;
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
