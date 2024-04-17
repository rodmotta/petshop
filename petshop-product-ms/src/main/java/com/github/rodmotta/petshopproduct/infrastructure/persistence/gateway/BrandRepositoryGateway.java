package com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper.BrandMapper;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper.CategoryMapper;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.BrandRepository;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.CategoryRepository;
import com.github.rodmotta.petshopproduct.model.entities.Brand;
import com.github.rodmotta.petshopproduct.model.entities.Category;
import com.github.rodmotta.petshopproduct.model.gateways.BrandGateway;
import com.github.rodmotta.petshopproduct.model.gateways.CategoryGateway;

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
