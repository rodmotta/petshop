package com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa;

import com.github.rodmotta.petshop.v2.adapters.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressJpaRepository extends JpaRepository<AddressEntity, UUID> {
    List<AddressEntity> findByCustomerId(UUID customerId);
}
