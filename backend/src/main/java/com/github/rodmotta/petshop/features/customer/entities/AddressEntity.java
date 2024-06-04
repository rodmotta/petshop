package com.github.rodmotta.petshop.features.customer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
