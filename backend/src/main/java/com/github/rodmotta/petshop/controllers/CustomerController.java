package com.github.rodmotta.petshop.controllers;

import com.github.rodmotta.petshop.dtos.requests.AddressRequest;
import com.github.rodmotta.petshop.dtos.responses.AddressResponse;
import com.github.rodmotta.petshop.dtos.responses.CustomerResponse;
import com.github.rodmotta.petshop.services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@Tag(name = "Customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("customer")
    @ResponseStatus(OK)
    public CustomerResponse getCustomer() {
        return service.getCustomer();
    }

    @GetMapping("customer/address")
    @ResponseStatus(OK)
    public List<AddressResponse> getAddress() {
        return service.getAddress();
    }

    @PostMapping("customer/address")
    @ResponseStatus(CREATED)
    public void createAddress(@RequestBody AddressRequest addressRequest) {
        service.createAddress(addressRequest);
    }

    @PutMapping("customer/address/{addressId}")
    @ResponseStatus(NO_CONTENT)
    public void updateAddress(@PathVariable UUID addressId, @RequestBody AddressRequest addressRequest) {
        service.updateAddress(addressId, addressRequest);
    }

    @DeleteMapping("customer/address/{addressId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteAddress(@PathVariable UUID addressId) {
        service.deleteAddress(addressId);
    }
}
