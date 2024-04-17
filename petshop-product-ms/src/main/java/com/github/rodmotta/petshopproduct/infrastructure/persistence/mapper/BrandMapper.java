package com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.BrandEntity;
import com.github.rodmotta.petshopproduct.model.entities.Brand;
import com.github.rodmotta.petshopproduct.model.vo.Name;

import java.util.Objects;

public class BrandMapper {

    private BrandMapper() {
    }

    public static BrandEntity converter(Brand brand) {
        return new BrandEntity(
                brand.getId(),
                Objects.nonNull(brand.getName()) ? brand.getName().value() : null);
    }

    public static Brand converter(BrandEntity brandEntity) {
        return new Brand(brandEntity.getId(), new Name(brandEntity.getName()));
    }
}
