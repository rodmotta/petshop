package com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.BrandEntity;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.CategoryEntity;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.ProductEntity;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.SubCategoryEntity;
import com.github.rodmotta.petshopproduct.domain.model.Brand;
import com.github.rodmotta.petshopproduct.domain.model.Category;
import com.github.rodmotta.petshopproduct.domain.model.Product;
import com.github.rodmotta.petshopproduct.domain.model.SubCategory;
import com.github.rodmotta.petshopproduct.domain.vo.Name;

import java.util.List;
import java.util.Objects;

public class ProductMapper {

    private ProductMapper() {
    }

    public static ProductEntity converter(Product product) {
        CategoryEntity categoryEntity = CategoryMapper.converter(product.getCategory());
        SubCategoryEntity subCategoryEntity = SubCategoryMapper.converter(product.getSubCategory());
        BrandEntity brandEntity = BrandMapper.converter(product.getBrand());

        return new ProductEntity(
                Objects.nonNull(product.getId()) ? product.getId() : null,
                product.getName().value(), product.getDescription().value(), product.getPrice().value(),
                categoryEntity, subCategoryEntity, brandEntity);
    }

    public static Product converter(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .category(new Category(productEntity.getCategory().getId(), new Name(productEntity.getCategory().getName())))
                .subCategory(new SubCategory(productEntity.getSubCategory().getId(), new Name(productEntity.getSubCategory().getName())))
                .brand(new Brand(productEntity.getBrand().getId(), new Name(productEntity.getBrand().getName())))
                .build();
    }

    public static List<Product> converter(List<ProductEntity> products) {
        return products.stream()
                .map(product -> Product.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .build())
                .toList();
    }
}
