package com.github.rodmotta.petshopproduct.domain.gateways;

import com.github.rodmotta.petshopproduct.domain.model.Category;

import java.util.Optional;
import java.util.UUID;

public interface CategoryGateway {
    Optional<Category> findById(UUID categoryId);
}
