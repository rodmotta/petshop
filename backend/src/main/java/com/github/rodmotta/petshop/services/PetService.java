package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dtos.mappers.PetMapper;
import com.github.rodmotta.petshop.dtos.responses.CategoryResponse;
import com.github.rodmotta.petshop.dtos.responses.PetResponse;
import com.github.rodmotta.petshop.persistence.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public List<PetResponse> getPets() {
        return petRepository.findAll().stream()
                .map(PetMapper::entityToResponse)
                .toList();
    }
}
