package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dtos.mappers.CategoryMapper;
import com.github.rodmotta.petshop.dtos.responses.CategoryResponse;
import com.github.rodmotta.petshop.persistence.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::entityToResponse)
                .toList();
    }
}
