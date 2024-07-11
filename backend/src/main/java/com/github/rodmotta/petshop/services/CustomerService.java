package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dtos.mappers.AddressMapper;
import com.github.rodmotta.petshop.dtos.mappers.CustomerMapper;
import com.github.rodmotta.petshop.dtos.requests.AddressRequest;
import com.github.rodmotta.petshop.dtos.requests.CreateUserRequest;
import com.github.rodmotta.petshop.dtos.responses.AddressResponse;
import com.github.rodmotta.petshop.dtos.responses.CustomerResponse;
import com.github.rodmotta.petshop.errors.exception.ForbiddenException;
import com.github.rodmotta.petshop.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.errors.exception.ServiceException;
import com.github.rodmotta.petshop.persistence.entities.AddressEntity;
import com.github.rodmotta.petshop.persistence.entities.CustomerEntity;
import com.github.rodmotta.petshop.persistence.repositories.AddressRepository;
import com.github.rodmotta.petshop.persistence.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.github.rodmotta.petshop.dtos.mappers.AddressMapper.addressRequestToEntity;
import static com.github.rodmotta.petshop.dtos.mappers.CustomerMapper.userRequestToCustomerEntity;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerResponse getCustomer() {
        CustomerEntity loggedCustomer = getLoggedCustomer();
        return CustomerMapper.entityToResponse(loggedCustomer);
    }

    public void create(UUID id, CreateUserRequest userRequest) {
        CustomerEntity customerEntity = userRequestToCustomerEntity(id, userRequest);
        customerRepository.save(customerEntity);
    }

    public List<AddressResponse> getAddress() {
        CustomerEntity loggedCustomer = getLoggedCustomer();

        return loggedCustomer.getAddresses()
                .stream()
                .map(AddressMapper::addressEntityToResponse)
                .toList();
    }

    public void createAddress(AddressRequest addressRequest) {
        CustomerEntity loggedCustomer = getLoggedCustomer();

        if (loggedCustomer.getAddresses().size() >= 5) throw new ServiceException("Address limit exceeded.");

        AddressEntity addressEntity = addressRequestToEntity(addressRequest, loggedCustomer.getId());
        addressRepository.save(addressEntity);
    }

    public void updateAddress(UUID addressId, AddressRequest addressRequest) {
        AddressEntity addressEntity = getCustomerAddressValidated(addressId);

        addressEntity.setStreet(addressRequest.street());
        addressEntity.setDistrict(addressRequest.district());
        addressEntity.setCity(addressRequest.city());
        addressEntity.setState(addressRequest.state());
        addressEntity.setZipCode(addressRequest.zipcode());
        addressRepository.save(addressEntity);
    }

    public void deleteAddress(UUID addressId) {
        AddressEntity addressEntity = getCustomerAddressValidated(addressId);
        addressRepository.delete(addressEntity);
    }

    private CustomerEntity getLoggedCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return customerRepository.findById(UUID.fromString(authentication.getName()))
                .orElseThrow(() -> new NotFoundException("Customer not found."));
    }

    private AddressEntity getCustomerAddressValidated(UUID addressId) {
        CustomerEntity loggedCustomer = getLoggedCustomer();

        return loggedCustomer.getAddresses()
                .stream()
                .filter(address -> address.getId().equals(addressId))
                .findAny()
                .orElseThrow(() -> new ForbiddenException("User without permission"));
    }
}
