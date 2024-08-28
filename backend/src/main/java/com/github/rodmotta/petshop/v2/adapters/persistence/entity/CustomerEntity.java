package com.github.rodmotta.petshop.v2.adapters.persistence.entity;

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
@Table(name = "customers")
public class CustomerEntity {

    @Id
    private UUID id;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<AddressEntity> addresses;
    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<OrderEntity> orders;
}
