package com.github.rodmotta.petshop.dtos.mappers;

import com.github.rodmotta.petshop.dtos.responses.BrandResponse;
import com.github.rodmotta.petshop.v2.adapters.persistence.entity.BrandEntity;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BrandMapper {

    public static BrandResponse entityToResponse(BrandEntity brandEntity) {
        return new BrandResponse(
                brandEntity.getId(),
                brandEntity.getName());
    }
}
