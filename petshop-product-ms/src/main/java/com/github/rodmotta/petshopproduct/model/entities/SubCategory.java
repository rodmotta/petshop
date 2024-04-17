package com.github.rodmotta.petshopproduct.model.entities;

import com.github.rodmotta.petshopproduct.model.vo.Name;

import java.util.UUID;

public class SubCategory {
    private UUID id;
    private Name name;

    public SubCategory(UUID id) {
        this.id = id;
    }

    public SubCategory(UUID id, Name name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
