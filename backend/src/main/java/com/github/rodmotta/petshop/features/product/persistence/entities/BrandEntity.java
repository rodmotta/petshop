package com.github.rodmotta.petshop.features.product.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "brand", fetch = LAZY)
    private List<ProductEntity> products;
}
