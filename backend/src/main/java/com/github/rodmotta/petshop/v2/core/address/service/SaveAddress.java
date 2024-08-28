package com.github.rodmotta.petshop.v2.core.address.service;

import com.github.rodmotta.petshop.v2.core.address.model.Address;
import com.github.rodmotta.petshop.v2.core.address.model.AddressRepository;
import com.github.rodmotta.petshop.v2.core.shared.SecurityProvider;
import com.github.rodmotta.petshop.v2.core.shared.UseCaseVoid;
import com.github.rodmotta.petshop.v2.core.shared.exception.ServiceException;
import com.github.rodmotta.petshop.v2.core.user.model.User;

import java.util.List;

public class SaveAddress implements UseCaseVoid<Address> {

    private final SecurityProvider securityProvider;
    private final AddressRepository addressRepository;

    public SaveAddress(SecurityProvider securityProvider, AddressRepository addressRepository) {
        this.securityProvider = securityProvider;
        this.addressRepository = addressRepository;
    }

    @Override
    public void execute(Address address) {
        User authenticatedUser = securityProvider.getAuthenticatedUser();
        // fixme - validar role do usuario
        List<Address> addresses = addressRepository.findByCustomerId(authenticatedUser.id());
        if (addresses.size() >= 5) throw new ServiceException("Address limit exceeded.");
        addressRepository.save(address, authenticatedUser.id());
    }
}
