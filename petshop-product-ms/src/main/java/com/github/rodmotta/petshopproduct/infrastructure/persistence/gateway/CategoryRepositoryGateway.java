package com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.ProductEntity;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper.CategoryMapper;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper.ProductMapper;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.CategoryRepository;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.ProductRepository;
import com.github.rodmotta.petshopproduct.model.entities.Category;
import com.github.rodmotta.petshopproduct.model.entities.Product;
import com.github.rodmotta.petshopproduct.model.gateways.CategoryGateway;
import com.github.rodmotta.petshopproduct.model.gateways.ProductGateway;

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
