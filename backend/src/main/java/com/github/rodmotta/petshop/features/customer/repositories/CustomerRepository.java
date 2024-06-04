package com.github.rodmotta.petshop.features.customer.repositories;

import com.github.rodmotta.petshop.features.customer.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
