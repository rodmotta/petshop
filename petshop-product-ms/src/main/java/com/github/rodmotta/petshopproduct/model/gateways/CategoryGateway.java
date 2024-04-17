package com.github.rodmotta.petshopproduct.model.gateways;

import com.github.rodmotta.petshopproduct.model.entities.Category;

import java.util.Optional;
import java.util.UUID;

public interface CategoryGateway {
    Optional<Category> findById(UUID categoryId);
}
