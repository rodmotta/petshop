package com.github.rodmotta.petshop.v2.core.address.service;

import com.github.rodmotta.petshop.v2.core.address.model.Address;
import com.github.rodmotta.petshop.v2.core.address.model.AddressRepository;
import com.github.rodmotta.petshop.v2.core.shared.SecurityProvider;
import com.github.rodmotta.petshop.v2.core.shared.UseCaseNoArgs;
import com.github.rodmotta.petshop.v2.core.user.model.User;

import java.util.List;

public class GetAddress implements UseCaseNoArgs<List<Address>> {

    private final SecurityProvider securityProvider;
    private final AddressRepository addressRepository;

    public GetAddress(SecurityProvider securityProvider, AddressRepository addressRepository) {
        this.securityProvider = securityProvider;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> execute() {
        User authenticatedUser = securityProvider.getAuthenticatedUser();
        return addressRepository.findByCustomerId(authenticatedUser.id());
    }
}
