package com.github.rodmotta.petshop.v2.adapters.persistence.repository;

import com.github.rodmotta.petshop.v2.adapters.persistence.entity.AddressEntity;
import com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa.AddressJpaRepository;
import com.github.rodmotta.petshop.v2.core.address.model.Address;
import com.github.rodmotta.petshop.v2.core.address.model.AddressRepository;
import com.github.rodmotta.petshop.v2.core.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryAdapter implements AddressRepository {

    private final AddressJpaRepository jpaRepository;

    @Override
    public void save(Address address, UUID customerId) {
        AddressEntity entity = AddressEntity.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .district(address.getDistrict())
                .city(address.getCity())
                .state(address.getState())
                .zipCode(address.getZipcode())
                .customerId(customerId)
                .build();
        jpaRepository.save(entity);
    }

    @Override
    public List<Address> findByCustomerId(UUID customerId) {
        List<AddressEntity> addresses = jpaRepository.findByCustomerId(customerId);
        return addresses.stream()
                .map(address -> new Address(address.getId(), address.getStreet(), address.getNumber(),
                        address.getDistrict(), address.getCity(), address.getState(), address.getZipCode()))
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void update(Address address) {
        AddressEntity entity = jpaRepository.findById(address.getId()).orElseThrow(() -> new NotFoundException(""));//fixme
        entity.setStreet(address.getStreet());
        entity.setNumber(address.getNumber());
        entity.setDistrict(address.getDistrict());
        entity.setCity(address.getCity());
        entity.setState(address.getState());
        entity.setZipCode(address.getZipcode());
        jpaRepository.save(entity);
    }
}
