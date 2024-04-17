package com.github.rodmotta.petshopproduct.infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "sub_category")
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    public SubCategoryEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubCategoryEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
