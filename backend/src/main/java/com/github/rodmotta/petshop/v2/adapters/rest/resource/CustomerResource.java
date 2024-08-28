package com.github.rodmotta.petshop.v2.adapters.rest.resource;

import com.github.rodmotta.petshop.v2.adapters.rest.request.AddressRequest;
import com.github.rodmotta.petshop.v2.core.address.model.Address;
import com.github.rodmotta.petshop.v2.core.address.service.DeleteAddress;
import com.github.rodmotta.petshop.v2.core.address.service.GetAddress;
import com.github.rodmotta.petshop.v2.core.address.service.SaveAddress;
import com.github.rodmotta.petshop.v2.core.address.service.UpdateAddress;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customers")
@RequiredArgsConstructor
public class CustomerResource {

    private final GetAddress getAddress;
    private final SaveAddress saveAddress;
    private final UpdateAddress updateAddress;
    private final DeleteAddress deleteAddress;

    @GetMapping("/addresses")
    @ResponseStatus(OK)
    public List<Address> getAdresses() {
        return getAddress.execute();
    }

    @PostMapping("/address")
    @ResponseStatus(CREATED)
    public void createAddress(@RequestBody @Valid AddressRequest addressRequest) {
        //fixme - criar mapper
        Address address = new Address(addressRequest.street(), addressRequest.number(), addressRequest.district(), addressRequest.city(), addressRequest.state(), addressRequest.zipcode());
        saveAddress.execute(address);
    }

    @PutMapping("/address/{addressId}")
    @ResponseStatus(NO_CONTENT)
    public void updateAddress(@PathVariable UUID addressId, @RequestBody @Valid AddressRequest addressRequest) {
        //fixme - criar mapper
        Address address = new Address(addressId, addressRequest.street(), addressRequest.number(), addressRequest.district(), addressRequest.city(), addressRequest.state(), addressRequest.zipcode());
        updateAddress.execute(address);
    }

    @DeleteMapping("/address/{addressId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteAddress(Authentication authentication, @PathVariable UUID addressId) {
        deleteAddress.execute(addressId);
    }
}
