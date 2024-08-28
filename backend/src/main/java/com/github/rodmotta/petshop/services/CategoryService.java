package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dtos.mappers.CategoryMapper;
import com.github.rodmotta.petshop.dtos.responses.CategoryResponse;
import com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public List<CategoryResponse> getCategories() {
        return categoryJpaRepository.findAll().stream()
                .map(CategoryMapper::entityToResponse)
                .toList();
    }
}
