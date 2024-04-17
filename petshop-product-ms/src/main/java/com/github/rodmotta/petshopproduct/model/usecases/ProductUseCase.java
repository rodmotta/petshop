package com.github.rodmotta.petshopproduct.model.usecases;

import com.github.rodmotta.petshopproduct.model.entities.Product;
import com.github.rodmotta.petshopproduct.model.gateways.BrandGateway;
import com.github.rodmotta.petshopproduct.model.gateways.CategoryGateway;
import com.github.rodmotta.petshopproduct.model.gateways.ProductGateway;
import com.github.rodmotta.petshopproduct.model.gateways.SubCategoryGateway;

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
                .orElseThrow(() -> new RuntimeException("Product not found."));
    }

    public void create(Product product) {
        brandGateway.findById(product.getBrand().getId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        categoryGateway.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        subCategoryGateway.findById(product.getSubCategory().getId())
                .orElseThrow(() -> new RuntimeException("Sub-category not found"));

        productGateway.create(product);
    }

    public void update(Product product) {
        productGateway.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product not found."));

        brandGateway.findById(product.getBrand().getId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        categoryGateway.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        subCategoryGateway.findById(product.getSubCategory().getId())
                .orElseThrow(() -> new RuntimeException("Sub-category not found"));

        productGateway.update(product);
    }

    public void deleteById(UUID productId) {
        productGateway.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found."));

        productGateway.delete(productId);
    }
}
