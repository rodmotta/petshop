package com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.BrandEntity;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.CategoryEntity;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.ProductEntity;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.SubCategoryEntity;
import com.github.rodmotta.petshopproduct.model.entities.Product;
import com.github.rodmotta.petshopproduct.model.vo.Description;
import com.github.rodmotta.petshopproduct.model.vo.Name;
import com.github.rodmotta.petshopproduct.model.vo.Price;

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
        return new Product(productEntity.getId(), new Name(productEntity.getName()), new Description(productEntity.getDescription()),
                new Price(productEntity.getPrice()), null, null, null);
    }
}
