package com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, UUID> {
}
