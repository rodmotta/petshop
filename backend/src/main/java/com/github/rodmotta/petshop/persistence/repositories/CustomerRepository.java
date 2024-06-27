package com.github.rodmotta.petshop.persistence.repositories;

import com.github.rodmotta.petshop.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
