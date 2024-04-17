package com.github.rodmotta.petshopproduct.domain.gateways;

import com.github.rodmotta.petshopproduct.domain.model.Brand;

import java.util.Optional;
import java.util.UUID;

public interface BrandGateway {
    Optional<Brand> findById(UUID brandId);
}
