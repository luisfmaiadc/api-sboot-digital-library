package com.portfolio.api_sboot_digital_library.repository;

import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
