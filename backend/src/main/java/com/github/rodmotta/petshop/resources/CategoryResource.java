package com.github.rodmotta.petshop.resources;

import com.github.rodmotta.petshop.dtos.responses.BrandResponse;
import com.github.rodmotta.petshop.dtos.responses.CategoryResponse;
import com.github.rodmotta.petshop.services.BrandService;
import com.github.rodmotta.petshop.services.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Tag(name = "Categories")
@RequiredArgsConstructor
public class CategoryResource {

    private final CategoryService service;

    @GetMapping("categories")
    @ResponseStatus(OK)
    public List<CategoryResponse> getCategories() {
        return service.getCategories();
    }
}
