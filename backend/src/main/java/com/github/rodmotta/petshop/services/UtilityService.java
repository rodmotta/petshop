package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.clients.ViaCEPClient;
import com.github.rodmotta.petshop.dtos.responses.AddressResponse;
import com.github.rodmotta.petshop.dtos.responses.ViaCEPResponse;
import com.github.rodmotta.petshop.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.errors.exception.ServiceException;
import org.springframework.stereotype.Service;

import static com.github.rodmotta.petshop.dtos.mappers.AddressMapper.viaCEPResponseToResponse;

@Service
public class UtilityService {

    private final ViaCEPClient viaCEPClient;

    public UtilityService(ViaCEPClient viaCEPClient) {
        this.viaCEPClient = viaCEPClient;
    }

    public AddressResponse getBrazilAddressByZipcode(String zipcode) {
        if (!zipcode.matches("^\\d{8}$")) throw new ServiceException("Invalid zipcode");

        ViaCEPResponse viaCEPResponse = viaCEPClient.getAddressByCEP(zipcode);

        if (viaCEPResponse.erro() != null) throw new NotFoundException("Zipcode not found.");

        return viaCEPResponseToResponse(viaCEPResponse);
    }
}
