package com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.CategoryEntity;
import com.github.rodmotta.petshopproduct.domain.model.Category;
import com.github.rodmotta.petshopproduct.domain.vo.Name;

import java.util.Objects;

public class CategoryMapper {
    private CategoryMapper() {
    }

    public static CategoryEntity converter(Category category) {
        return new CategoryEntity(
                category.getId(),
                Objects.nonNull(category.getName()) ? category.getName().value() : null);
    }

    public static Category converter(CategoryEntity categoryEntity) {
        return new Category(categoryEntity.getId(), new Name(categoryEntity.getName()));
    }
}
