package com.github.rodmotta.petshopproduct.infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "stock")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private ProductEntity product;
    @Column(nullable = false)
    private int quantity;

    public StockEntity(UUID id, ProductEntity product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public StockEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
