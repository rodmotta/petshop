package com.github.rodmotta.petshop.features.product.persistence.repository;

import com.github.rodmotta.petshop.features.product.persistence.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
