package com.github.rodmotta.petshop.persistence.entities;

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
@Table(name = "animals")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "animal", fetch = LAZY)
    private List<ProductEntity> products;
}
