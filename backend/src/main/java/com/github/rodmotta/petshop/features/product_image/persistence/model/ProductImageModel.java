package com.github.rodmotta.petshop.features.product_image.persistence.model;

import com.github.rodmotta.petshop.features.product.persistence.model.ProductModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_image")
public class ProductImageModel {

    @Id
    private UUID id;
    private String url;
    private Integer position;
    @Column(name = "product_id")
    private UUID productId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductModel product;
}
