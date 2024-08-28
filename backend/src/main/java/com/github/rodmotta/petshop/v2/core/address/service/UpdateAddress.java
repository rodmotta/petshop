package com.github.rodmotta.petshop.v2.core.address.service;

import com.github.rodmotta.petshop.v2.core.address.model.Address;
import com.github.rodmotta.petshop.v2.core.address.model.AddressRepository;
import com.github.rodmotta.petshop.v2.core.shared.SecurityProvider;
import com.github.rodmotta.petshop.v2.core.shared.UseCaseVoid;
import com.github.rodmotta.petshop.v2.core.shared.exception.ServiceException;
import com.github.rodmotta.petshop.v2.core.user.model.User;

import java.util.List;

public class UpdateAddress implements UseCaseVoid<Address> {

    private final SecurityProvider securityProvider;
    private final AddressRepository addressRepository;

    public UpdateAddress(SecurityProvider securityProvider, AddressRepository addressRepository) {
        this.securityProvider = securityProvider;
        this.addressRepository = addressRepository;
    }

    @Override
    public void execute(Address address) {
        User authenticatedUser = securityProvider.getAuthenticatedUser();
        List<Address> addresses = addressRepository.findByCustomerId(authenticatedUser.id());
        addresses.stream()
                .filter(address1 -> address1.getId().equals(address.getId()))
                .findFirst()
                .orElseThrow(() -> new ServiceException(""));//fixme
        addressRepository.update(address);
    }
}
