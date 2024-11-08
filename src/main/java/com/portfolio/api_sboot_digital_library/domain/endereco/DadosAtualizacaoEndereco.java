package com.portfolio.api_sboot_digital_library.domain.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(@NotNull Integer id, String cep, @NotNull String numero) {
}
