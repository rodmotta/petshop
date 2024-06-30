package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dtos.mappers.CustomerMapper;
import com.github.rodmotta.petshop.dtos.requests.CreateUserRequest;
import com.github.rodmotta.petshop.dtos.responses.CustomerResponse;
import com.github.rodmotta.petshop.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.persistence.entities.CustomerEntity;
import com.github.rodmotta.petshop.persistence.repositories.AddressRepository;
import com.github.rodmotta.petshop.persistence.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.github.rodmotta.petshop.dtos.mappers.CustomerMapper.userRequestToCustomerEntity;

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

    public void create(UUID id, CreateUserRequest userRequest) {
        CustomerEntity customerEntity = userRequestToCustomerEntity(id, userRequest);
        customerRepository.save(customerEntity);
    }
}
