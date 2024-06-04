package com.github.rodmotta.petshop.features.customer.controller;

import com.github.rodmotta.petshop.features.customer.representation.response.CustomerResponse;
import com.github.rodmotta.petshop.features.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Tag(name = "Customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("customer/{customerId}")
    @ResponseStatus(OK)
    public CustomerResponse findById(@PathVariable UUID customerId) {
        return customerService.findById(customerId);
    }

    @PostMapping("customer")
    @ResponseStatus(OK)
    public CustomerResponse create(@PathVariable UUID customerId) {
        return customerService.findById(customerId);
    }

    @GetMapping("customer/{customerId}/address")
    @ResponseStatus(OK)
    public CustomerResponse addAddress(@PathVariable UUID customerId) {
        return customerService.findById(customerId);
    }

}
