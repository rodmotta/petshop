package com.github.rodmotta.petshop.features.product.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    private BigDecimal price;
    @Column(name = "animal_id")
    private UUID animalId;
    @Column(name = "category_id")
    private UUID categoryId;
    @Column(name = "brand_id")
    private UUID brandId;

    @OneToMany(mappedBy = "product", fetch = LAZY)
    private List<ImageEntity> images;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "animal_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AnimalEntity animal;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CategoryEntity category;
    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = "brand_id",  referencedColumnName = "id", insertable = false, updatable = false)
    private BrandEntity brand;
}
