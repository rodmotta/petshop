package com.github.rodmotta.petshop.features.customer.service;

import com.github.rodmotta.petshop.commons.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.features.customer.entities.CustomerEntity;
import com.github.rodmotta.petshop.features.customer.mapper.CustomerMapper;
import com.github.rodmotta.petshop.features.customer.repositories.AddressRepository;
import com.github.rodmotta.petshop.features.customer.repositories.CustomerRepository;
import com.github.rodmotta.petshop.features.customer.representation.response.CustomerResponse;
import com.github.rodmotta.petshop.features.user.representation.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.github.rodmotta.petshop.features.customer.mapper.CustomerMapper.userRequestToCustomerEntity;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerResponse findById(UUID customerId) {
        return customerRepository.findById(customerId)
                .map(CustomerMapper::entityToResponse)
                .orElseThrow(() -> new NotFoundException("Customer not found."));
    }

    //todo - muito acoplamento
    public void create(UUID id, CreateUserRequest userRequest) {
        CustomerEntity customerEntity = userRequestToCustomerEntity(id, userRequest);
        customerRepository.save(customerEntity);
    }
}
