package com.github.rodmotta.petshop.features.customer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.FetchType.*;

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
}
