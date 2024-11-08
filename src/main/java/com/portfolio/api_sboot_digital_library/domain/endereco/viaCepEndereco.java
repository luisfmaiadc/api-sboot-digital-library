package com.portfolio.api_sboot_digital_library.domain.endereco;

public record viaCepEndereco(String cep, String logradouro, String bairro, String localidade, String uf, boolean erro) {
}
