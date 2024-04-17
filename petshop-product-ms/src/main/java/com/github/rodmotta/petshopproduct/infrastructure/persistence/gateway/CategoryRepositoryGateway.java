package com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper.CategoryMapper;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.CategoryRepository;
import com.github.rodmotta.petshopproduct.domain.model.Category;
import com.github.rodmotta.petshopproduct.domain.gateways.CategoryGateway;

import java.util.Optional;
import java.util.UUID;

public class CategoryRepositoryGateway implements CategoryGateway {
    private final CategoryRepository categoryRepository;

    public CategoryRepositoryGateway(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findById(UUID categoryId) {
        return categoryRepository.findById(categoryId)
                .map(CategoryMapper::converter);
    }
}
