package com.github.rodmotta.petshopproduct.domain.gateways;

import com.github.rodmotta.petshopproduct.domain.model.SubCategory;

import java.util.Optional;
import java.util.UUID;

public interface SubCategoryGateway {
    Optional<SubCategory> findById(UUID subCategoryId);
}
