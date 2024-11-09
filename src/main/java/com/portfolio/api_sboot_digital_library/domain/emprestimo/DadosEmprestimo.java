package com.portfolio.api_sboot_digital_library.domain.emprestimo;

import com.portfolio.api_sboot_digital_library.domain.livro.Livro;
import com.portfolio.api_sboot_digital_library.domain.users.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosEmprestimo(String nomeUsuario, String nomeLivro, LocalDateTime dataEmprestimo, String statusEmprestimo) {

    public DadosEmprestimo(Usuario usuario, Livro livro, Emprestimo emprestimo) {
        this(usuario.getNome(), livro.getTitulo(), emprestimo.getDataEmprestimo(), emprestimo.getStatus());
    }
}
