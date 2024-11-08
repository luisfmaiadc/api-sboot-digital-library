package com.portfolio.api_sboot_digital_library.repository;

import com.portfolio.api_sboot_digital_library.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
