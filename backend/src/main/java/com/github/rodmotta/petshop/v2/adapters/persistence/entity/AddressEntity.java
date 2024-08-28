package com.github.rodmotta.petshop.v2.adapters.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address", indexes = @Index(name = "idx_customer_id", columnList = "customerId"))
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 100, nullable = false)
    private String street;
    @Column(nullable = false)
    private int number;
    @Column(length = 100, nullable = false)
    private String district;
    @Column(length = 50, nullable = false)
    private String city;
    @Column(length = 50, nullable = false)
    private String state;
    @Column(length = 10, nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private UUID customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", referencedColumnName = "id", insertable = false, updatable = false)
    private CustomerEntity customer;
}
