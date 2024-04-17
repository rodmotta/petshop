package com.github.rodmotta.petshopproduct.infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 30, nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;
    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategoryEntity subCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    private BrandEntity brand;

    public ProductEntity(UUID id, String name, String description, BigDecimal price, CategoryEntity category, SubCategoryEntity subCategory, BrandEntity brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
        this.brand = brand;
    }

    public ProductEntity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public SubCategoryEntity getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryEntity subCategory) {
        this.subCategory = subCategory;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
