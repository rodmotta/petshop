package com.github.rodmotta.petshop.dtos.responses;

public record ViaCEPResponse(
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String cep,
        String erro //apenas usado quando CEP buscado nao tem registro
) {
}
