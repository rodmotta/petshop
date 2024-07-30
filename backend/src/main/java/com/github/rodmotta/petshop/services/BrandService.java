package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dtos.mappers.BrandMapper;
import com.github.rodmotta.petshop.dtos.responses.BrandResponse;
import com.github.rodmotta.petshop.persistence.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public List<BrandResponse> getBrands() {
        return brandRepository.findAll().stream()
                .map(BrandMapper::entityToResponse)
                .toList();
    }
}
