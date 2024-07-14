package com.github.rodmotta.petshop.resources;

import com.github.rodmotta.petshop.dtos.responses.AddressResponse;
import com.github.rodmotta.petshop.services.UtilityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Utilities")
@RequiredArgsConstructor
public class UtilityResource {

    private final UtilityService service;

    @GetMapping("utility/brazil-zipcode/{zipcode}/address")
    public AddressResponse getBrazilAddressByZipcode(@PathVariable String zipcode) {
        return service.getBrazilAddressByZipcode(zipcode);
    }
}
