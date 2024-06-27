package com.github.rodmotta.petshop.persistence.repositories;

import com.github.rodmotta.petshop.persistence.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
}
