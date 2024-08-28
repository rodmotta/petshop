package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dtos.mappers.BrandMapper;
import com.github.rodmotta.petshop.dtos.responses.BrandResponse;
import com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa.BrandJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandJpaRepository brandJpaRepository;

    public List<BrandResponse> getBrands() {
        return brandJpaRepository.findAll().stream()
                .map(BrandMapper::entityToResponse)
                .toList();
    }
}
