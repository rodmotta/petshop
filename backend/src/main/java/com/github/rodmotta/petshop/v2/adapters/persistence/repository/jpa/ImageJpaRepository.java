package com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa;

import com.github.rodmotta.petshop.v2.adapters.persistence.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageJpaRepository extends JpaRepository<ImageEntity, UUID> {
}
