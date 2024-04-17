package com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper.BrandMapper;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.BrandRepository;
import com.github.rodmotta.petshopproduct.domain.model.Brand;
import com.github.rodmotta.petshopproduct.domain.gateways.BrandGateway;

import java.util.Optional;
import java.util.UUID;

public class BrandRepositoryGateway implements BrandGateway {
    private final BrandRepository brandRepository;

    public BrandRepositoryGateway(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Brand> findById(UUID categoryId) {
        return brandRepository.findById(categoryId)
                .map(BrandMapper::converter);
    }
}
