package com.portfolio.api_sboot_digital_library.controller;

import com.portfolio.api_sboot_digital_library.domain.endereco.DadosAtualizacaoEndereco;
import com.portfolio.api_sboot_digital_library.domain.users.DadosAtualizacaoUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.DadosCadastroUsuario;
import com.portfolio.api_sboot_digital_library.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
        return usuarioService.cadastrarUsuario(dados, uriComponentsBuilder);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarUsuario(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        return usuarioService.atualizarUsuario(dados);
    }

    @PutMapping("/endereco")
    @Transactional
    public ResponseEntity atualizarEndereco(@RequestBody @Valid DadosAtualizacaoEndereco dados) {
        return usuarioService.atualizarEndereco(dados);
    }
}
