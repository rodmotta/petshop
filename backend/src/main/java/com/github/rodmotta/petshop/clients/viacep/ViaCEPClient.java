package com.github.rodmotta.petshop.clients.viacep;

import com.github.rodmotta.petshop.dtos.responses.ViaCEPResponse;
import com.github.rodmotta.petshop.errors.handler.ViaCEPErrorHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep",
        url = "https://viacep.com.br",
        configuration = ViaCEPErrorHandler.class)
public interface ViaCEPClient {

    @GetMapping("/ws/{CEP}/json")
    ViaCEPResponse getAddressByCEP(@PathVariable String CEP);
}