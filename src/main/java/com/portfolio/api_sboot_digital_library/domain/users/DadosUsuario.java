package com.portfolio.api_sboot_digital_library.domain.users;

import com.portfolio.api_sboot_digital_library.domain.endereco.Endereco;

import java.time.LocalDate;

public record DadosUsuario(String nome,
                           LocalDate dataNascimento,
                           String telefone,
                           String cep,
                           String logradouro,
                           String numero,
                           String bairro,
                           String cidade,
                           String estado) {

    public DadosUsuario(Usuario usuario, Endereco endereco) {
        this(
                usuario.getNome(),
                usuario.getDataNascimento(),
                usuario.getTelefone(),
                endereco.getCep(),
                endereco.getNumero(),
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado()
        );
    }
}
