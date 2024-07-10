package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.clients.viacep.ViaCEPClient;
import com.github.rodmotta.petshop.dtos.responses.AddressResponse;
import com.github.rodmotta.petshop.dtos.responses.ViaCEPResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.github.rodmotta.petshop.dtos.mappers.AddressMapper.viaCEPResponseToResponse;

@Service
@RequiredArgsConstructor
public class UtilityService {

    private final ViaCEPClient viaCEPClient;

    public AddressResponse getBrazilAddressByZipcode(String zipcode) {
        ViaCEPResponse viaCEPResponse = viaCEPClient.getAddressByCEP(zipcode);
        return viaCEPResponseToResponse(viaCEPResponse);
    }
}
