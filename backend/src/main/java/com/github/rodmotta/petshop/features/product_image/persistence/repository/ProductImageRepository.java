package com.github.rodmotta.petshop.features.product_image.persistence.repository;

import com.github.rodmotta.petshop.features.product_image.persistence.model.ProductImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductImageRepository extends JpaRepository<ProductImageModel, UUID> {
}
