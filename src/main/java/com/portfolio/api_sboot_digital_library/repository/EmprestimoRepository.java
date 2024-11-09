package com.portfolio.api_sboot_digital_library.repository;

import com.portfolio.api_sboot_digital_library.domain.emprestimo.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository <Emprestimo, Integer> {
}
