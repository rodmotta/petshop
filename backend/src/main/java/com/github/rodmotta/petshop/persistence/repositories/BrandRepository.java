package com.github.rodmotta.petshop.persistence.repositories;

import com.github.rodmotta.petshop.persistence.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<BrandEntity, UUID> {
}
