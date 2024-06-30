package com.github.rodmotta.petshop.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<AddressEntity> addresses;
    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<OrderEntity> orders;
}
