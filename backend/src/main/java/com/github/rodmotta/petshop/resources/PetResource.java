package com.github.rodmotta.petshop.resources;

import com.github.rodmotta.petshop.dtos.responses.PetResponse;
import com.github.rodmotta.petshop.services.PetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Tag(name = "Pets")
@RequiredArgsConstructor
public class PetResource {

    private final PetService service;

    @GetMapping("pets")
    @ResponseStatus(OK)
    public List<PetResponse> getPets() {
        return service.getPets();
    }
}
