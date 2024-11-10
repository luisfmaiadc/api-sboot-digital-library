package com.portfolio.api_sboot_digital_library.repository;

import com.portfolio.api_sboot_digital_library.domain.emprestimo.Emprestimo;
import com.portfolio.api_sboot_digital_library.domain.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository <Emprestimo, Integer> {

    @Query("SELECT e.livro FROM Emprestimo e WHERE e.usuario.id = :idUsuario")
    List<Livro> findHistoricoEmprestimo(Integer idUsuario);
}
