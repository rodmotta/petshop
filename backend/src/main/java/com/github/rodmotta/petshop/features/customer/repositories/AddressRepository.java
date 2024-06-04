package com.github.rodmotta.petshop.features.customer.repositories;

import com.github.rodmotta.petshop.features.customer.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
}
