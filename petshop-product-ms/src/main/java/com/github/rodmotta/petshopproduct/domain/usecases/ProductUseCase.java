package com.github.rodmotta.petshopproduct.domain.usecases;

import com.github.rodmotta.petshopproduct.domain.exceptions.NotFoundException;
import com.github.rodmotta.petshopproduct.domain.model.Product;
import com.github.rodmotta.petshopproduct.domain.gateways.BrandGateway;
import com.github.rodmotta.petshopproduct.domain.gateways.CategoryGateway;
import com.github.rodmotta.petshopproduct.domain.gateways.ProductGateway;
import com.github.rodmotta.petshopproduct.domain.gateways.SubCategoryGateway;

import java.util.List;
import java.util.UUID;

public class ProductUseCase {
    private final ProductGateway productGateway;
    private final CategoryGateway categoryGateway;
    private final SubCategoryGateway subCategoryGateway;
    private final BrandGateway brandGateway;

    public ProductUseCase(ProductGateway productGateway, CategoryGateway categoryGateway, SubCategoryGateway subCategoryGateway, BrandGateway brandGateway) {
        this.productGateway = productGateway;
        this.categoryGateway = categoryGateway;
        this.subCategoryGateway = subCategoryGateway;
        this.brandGateway = brandGateway;
    }

    public List<Product> findAll() {
        return productGateway.findAll();
    }

    public Product findById(UUID productId) {
        return productGateway.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found."));
    }

    public void create(Product product) {
        brandGateway.findById(product.getBrand().getId())
                .orElseThrow(() -> new NotFoundException("Brand not found"));

        categoryGateway.findById(product.getCategory().getId())
                .orElseThrow(() -> new NotFoundException("Category not found"));

        subCategoryGateway.findById(product.getSubCategory().getId())
                .orElseThrow(() -> new NotFoundException("Sub-category not found"));

        productGateway.create(product);
    }

    public void update(Product product) {
        productGateway.findById(product.getId())
                .orElseThrow(() -> new NotFoundException("Product not found."));

        brandGateway.findById(product.getBrand().getId())
                .orElseThrow(() -> new NotFoundException("Brand not found"));

        categoryGateway.findById(product.getCategory().getId())
                .orElseThrow(() -> new NotFoundException("Category not found"));

        subCategoryGateway.findById(product.getSubCategory().getId())
                .orElseThrow(() -> new NotFoundException("Sub-category not found"));

        productGateway.update(product);
    }

    public void deleteById(UUID productId) {
        productGateway.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found."));

        productGateway.delete(productId);
    }
}
