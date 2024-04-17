package com.github.rodmotta.petshopproduct.model.entities;

import com.github.rodmotta.petshopproduct.model.vo.Name;

import java.util.UUID;

public class Brand {
    private UUID id;
    private Name name;

    public Brand(UUID id, Name name) {
        this.id = id;
        this.name = name;
    }

    public Brand(UUID id) {
        this.id = id;
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
