package com.portfolio.api_sboot_digital_library.domain.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DadosCadastroUsuario(@NotBlank String nome,
                                   @NotNull LocalDate dataNascimento,
                                   @NotBlank String telefone,
                                   @NotBlank @Size(min = 8, max = 8, message = "O cep deve conter 8 caracteres.") String cep,
                                   @NotBlank @Size(min = 1, max = 5, message = "O número deve conter no mínimo 1 e no máximo 5 caracteres.") String numero) {
}