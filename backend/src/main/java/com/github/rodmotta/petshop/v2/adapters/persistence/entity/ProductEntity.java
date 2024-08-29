package com.github.rodmotta.petshop.v2.adapters.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private UUID code;
    private int version;
    private boolean active;
    private LocalDateTime createdAt;
    private String name;
    private BigDecimal price;
    @Column(name = "pet_id")
    private UUID petId;
    @Column(name = "category_id")
    private UUID categoryId;
    @Column(name = "brand_id")
    private UUID brandId;

    @OneToMany(mappedBy = "product", fetch = LAZY)
    private List<ImageEntity> images;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "pet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PetEntity pet;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CategoryEntity category;
    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", insertable = false, updatable = false)
    private BrandEntity brand;
}
