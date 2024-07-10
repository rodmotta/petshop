package com.github.rodmotta.petshop.dtos.responses;

public record ViaCEPResponse(
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String cep
) {
}
