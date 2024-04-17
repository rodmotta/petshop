package com.github.rodmotta.petshopproduct.model.gateways;

import com.github.rodmotta.petshopproduct.model.entities.Brand;

import java.util.Optional;
import java.util.UUID;

public interface BrandGateway {
    Optional<Brand> findById(UUID brandId);
}
