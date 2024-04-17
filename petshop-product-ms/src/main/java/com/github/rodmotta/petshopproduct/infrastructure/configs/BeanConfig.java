package com.github.rodmotta.petshopproduct.infrastructure.configs;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway.BrandRepositoryGateway;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway.CategoryRepositoryGateway;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway.ProductRepositoryGateway;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway.SubCategoryRepositoryGateway;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.BrandRepository;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.CategoryRepository;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.ProductRepository;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.SubCategoryRepository;
import com.github.rodmotta.petshopproduct.model.gateways.BrandGateway;
import com.github.rodmotta.petshopproduct.model.gateways.CategoryGateway;
import com.github.rodmotta.petshopproduct.model.gateways.ProductGateway;
import com.github.rodmotta.petshopproduct.model.gateways.SubCategoryGateway;
import com.github.rodmotta.petshopproduct.model.usecases.ProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {
    @Bean
    public ProductUseCase productUseCase(ProductGateway productGateway, CategoryGateway categoryGateway, SubCategoryGateway subCategoryGateway, BrandGateway brandGateway) {
        return new ProductUseCase(productGateway, categoryGateway, subCategoryGateway, brandGateway);
    }

    @Bean
    public ProductGateway productGateway(ProductRepository productRepository) {
        return new ProductRepositoryGateway(productRepository);
    }

    @Bean
    public CategoryGateway categoryGateway(CategoryRepository categoryRepository) {
        return new CategoryRepositoryGateway(categoryRepository);
    }

    @Bean
    public SubCategoryGateway subCategoryGateway(SubCategoryRepository subCategoryRepository) {
        return new SubCategoryRepositoryGateway(subCategoryRepository);
    }

    @Bean
    public BrandGateway brandGateway(BrandRepository brandRepository) {
        return new BrandRepositoryGateway(brandRepository);
    }


}
