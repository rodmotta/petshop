package com.github.rodmotta.petshop.controllers;

import com.github.rodmotta.petshop.dtos.requests.AddressRequest;
import com.github.rodmotta.petshop.dtos.responses.CustomerResponse;
import com.github.rodmotta.petshop.services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Tag(name = "Customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("customer/{customerId}")
    @ResponseStatus(OK)
    public CustomerResponse findById(@PathVariable UUID customerId) {
        return service.findById(customerId);
    }

    @PostMapping("customer/{customerId}/address")
    @ResponseStatus(OK)
    public void addAddress(@PathVariable UUID customerId, @RequestBody AddressRequest addressRequest) {
        service.addAddress(customerId, addressRequest);
    }
}
