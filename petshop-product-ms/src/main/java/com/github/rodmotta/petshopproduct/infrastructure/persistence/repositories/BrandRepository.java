package com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<BrandEntity, UUID> {
}
