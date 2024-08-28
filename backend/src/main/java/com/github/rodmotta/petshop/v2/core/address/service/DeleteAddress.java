package com.github.rodmotta.petshop.v2.core.address.service;

import com.github.rodmotta.petshop.v2.core.address.model.Address;
import com.github.rodmotta.petshop.v2.core.address.model.AddressRepository;
import com.github.rodmotta.petshop.v2.core.shared.SecurityProvider;
import com.github.rodmotta.petshop.v2.core.shared.UseCaseVoid;
import com.github.rodmotta.petshop.v2.core.shared.exception.ServiceException;
import com.github.rodmotta.petshop.v2.core.user.model.User;

import java.util.List;
import java.util.UUID;

public class DeleteAddress implements UseCaseVoid<UUID> {

    private final SecurityProvider securityProvider;
    private final AddressRepository addressRepository;

    public DeleteAddress(SecurityProvider securityProvider, AddressRepository addressRepository) {
        this.securityProvider = securityProvider;
        this.addressRepository = addressRepository;
    }

    @Override
    public void execute(UUID id) {
        User authenticatedUser = securityProvider.getAuthenticatedUser();
        List<Address> addresses = addressRepository.findByCustomerId(authenticatedUser.id());
        Address addressToDelete = addresses.stream()
                .filter(address -> address.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(""));//fixme
        addressRepository.deleteById(addressToDelete.getId());
    }
}
