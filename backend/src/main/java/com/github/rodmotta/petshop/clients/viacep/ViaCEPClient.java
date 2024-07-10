package com.github.rodmotta.petshop.clients.viacep;

import com.github.rodmotta.petshop.dtos.responses.ViaCEPResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep",
        url = "https://viacep.com.br")
public interface ViaCEPClient {

    @GetMapping("/ws/{CEP}/json")
    ViaCEPResponse getAddressByCEP(@PathVariable String CEP);
}
