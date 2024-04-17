package com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper.SubCategoryMapper;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.SubCategoryRepository;
import com.github.rodmotta.petshopproduct.model.entities.SubCategory;
import com.github.rodmotta.petshopproduct.model.gateways.SubCategoryGateway;

import java.util.Optional;
import java.util.UUID;

public class SubCategoryRepositoryGateway implements SubCategoryGateway {
    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryRepositoryGateway(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public Optional<SubCategory> findById(UUID subCategoryId) {
        return subCategoryRepository.findById(subCategoryId)
                .map(SubCategoryMapper::converter);
    }
}
