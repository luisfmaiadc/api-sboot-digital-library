package com.portfolio.api_sboot_digital_library.repository;

import com.portfolio.api_sboot_digital_library.domain.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
