package com.github.rodmotta.petshop.persistence.repositories;

import com.github.rodmotta.petshop.persistence.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<ImageEntity, UUID> {
}
