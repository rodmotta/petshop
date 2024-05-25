package com.github.rodmotta.petshop.features.product.persistence.repository;

import com.github.rodmotta.petshop.features.product.persistence.model.ProductImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductImageRepository extends JpaRepository<ProductImageModel, UUID> {
    int countByProductId(UUID productId);
}
