package com.github.rodmotta.petshop.dtos.mappers;

import com.github.rodmotta.petshop.dtos.responses.CategoryResponse;
import com.github.rodmotta.petshop.persistence.entities.CategoryEntity;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CategoryMapper {

    public static CategoryResponse entityToResponse(CategoryEntity categoryEntity) {
        return new CategoryResponse(
                categoryEntity.getId(),
                categoryEntity.getName());
    }
}
