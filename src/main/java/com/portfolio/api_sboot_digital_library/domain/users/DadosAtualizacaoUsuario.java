package com.portfolio.api_sboot_digital_library.domain.users;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoUsuario(@NotNull Integer id, String nome, LocalDate dataNascimento, String telefone) {

    public DadosAtualizacaoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getDataNascimento(), usuario.getTelefone());
    }

}
