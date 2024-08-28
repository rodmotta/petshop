package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dtos.mappers.PetMapper;
import com.github.rodmotta.petshop.dtos.responses.PetResponse;
import com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa.PetJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetJpaRepository petJpaRepository;

    public List<PetResponse> getPets() {
        return petJpaRepository.findAll().stream()
                .map(PetMapper::entityToResponse)
                .toList();
    }
}
