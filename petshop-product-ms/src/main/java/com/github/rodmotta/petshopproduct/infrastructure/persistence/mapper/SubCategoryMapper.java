package com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.SubCategoryEntity;
import com.github.rodmotta.petshopproduct.model.entities.SubCategory;
import com.github.rodmotta.petshopproduct.model.vo.Name;

import java.util.Objects;

public class SubCategoryMapper {

    private SubCategoryMapper() {
    }

    public static SubCategoryEntity converter(SubCategory subCategory) {
        return new SubCategoryEntity(
                subCategory.getId(),
                Objects.nonNull(subCategory.getName()) ? subCategory.getName().value() : null);
    }

    public static SubCategory converter(SubCategoryEntity subCategoryEntity) {
        return new SubCategory(subCategoryEntity.getId(), new Name(subCategoryEntity.getName()));
    }
}
