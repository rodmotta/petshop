package com.github.rodmotta.petshop.features.product.persistence.repository;

import com.github.rodmotta.petshop.features.product.persistence.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<ImageEntity, UUID> {
}
