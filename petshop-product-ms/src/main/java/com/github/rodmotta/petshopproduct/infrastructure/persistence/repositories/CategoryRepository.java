package com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
}
