package com.github.rodmotta.petshopproduct.presentation.dto.mapper;

import com.github.rodmotta.petshopproduct.model.entities.Brand;
import com.github.rodmotta.petshopproduct.model.entities.Category;
import com.github.rodmotta.petshopproduct.model.entities.Product;
import com.github.rodmotta.petshopproduct.model.entities.SubCategory;
import com.github.rodmotta.petshopproduct.presentation.dto.request.CreateProductRequest;
import com.github.rodmotta.petshopproduct.presentation.dto.request.UpdateProductRequest;
import com.github.rodmotta.petshopproduct.presentation.dto.response.BrandResponse;
import com.github.rodmotta.petshopproduct.presentation.dto.response.CategoryResponse;
import com.github.rodmotta.petshopproduct.presentation.dto.response.ProductResponse;
import com.github.rodmotta.petshopproduct.presentation.dto.response.SubCategoryResponse;

import java.util.List;

public class ProductMapper {
    private ProductMapper() {
    }

    public static Product converter(CreateProductRequest req) {
        return Product.builder()
                .name(req.name())
                .description(req.description())
                .price(req.price())
                .category(new Category(req.categoryId()))
                .subCategory(new SubCategory(req.subCategoryId()))
                .brand(new Brand(req.brandId()))
                .build();
    }

    public static Product converter(UpdateProductRequest req) {
        return Product.builder()
                .id(req.id())
                .name(req.name())
                .description(req.description())
                .price(req.price())
                .category(new Category(req.categoryId()))
                .subCategory(new SubCategory(req.subCategoryId()))
                .brand(new Brand(req.brandId()))
                .build();
    }

    public static ProductResponse converter(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName().value(),
                product.getDescription().value(),
                product.getPrice().value(),
                new CategoryResponse(product.getCategory().getId(), product.getCategory().getName().value()),
                new SubCategoryResponse(product.getSubCategory().getId(), product.getSubCategory().getName().value()),
                new BrandResponse(product.getBrand().getId(), product.getBrand().getName().value()));
    }

    public static List<ProductResponse> converter(List<Product> products) {
        return products.stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName().value(),
                        product.getDescription().value(),
                        product.getPrice().value()))
                .toList();
    }
}
