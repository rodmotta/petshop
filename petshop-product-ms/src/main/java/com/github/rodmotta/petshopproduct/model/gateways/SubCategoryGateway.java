package com.github.rodmotta.petshopproduct.model.gateways;

import com.github.rodmotta.petshopproduct.model.entities.SubCategory;

import java.util.Optional;
import java.util.UUID;

public interface SubCategoryGateway {
    Optional<SubCategory> findById(UUID subCategoryId);
}
