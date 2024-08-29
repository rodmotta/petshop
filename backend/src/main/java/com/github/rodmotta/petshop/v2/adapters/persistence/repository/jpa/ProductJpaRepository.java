package com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa;

import com.github.rodmotta.petshop.v2.adapters.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {
    Optional<ProductEntity> findByCodeAndActiveTrue(UUID productCode);
}
