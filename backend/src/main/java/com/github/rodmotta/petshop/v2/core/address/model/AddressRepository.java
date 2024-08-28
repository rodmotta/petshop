package com.github.rodmotta.petshop.v2.core.address.model;

import java.util.List;
import java.util.UUID;

public interface AddressRepository {
    void save(Address address, UUID customerId);
    List<Address> findByCustomerId(UUID customerId);
    void deleteById(UUID id);
    void update(Address address);
}
