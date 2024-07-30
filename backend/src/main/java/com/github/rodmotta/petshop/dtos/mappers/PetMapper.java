package com.github.rodmotta.petshop.dtos.mappers;

import com.github.rodmotta.petshop.dtos.responses.PetResponse;
import com.github.rodmotta.petshop.persistence.entities.PetEntity;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PetMapper {

    public static PetResponse entityToResponse(PetEntity petEntity) {
        return new PetResponse(
                petEntity.getId(),
                petEntity.getName());
    }
}
