package com.github.rodmotta.petshop.persistence.repositories;

import com.github.rodmotta.petshop.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
