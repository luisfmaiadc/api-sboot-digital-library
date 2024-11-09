package com.portfolio.api_sboot_digital_library.controller;

import com.portfolio.api_sboot_digital_library.domain.livro.Categoria;
import com.portfolio.api_sboot_digital_library.domain.livro.DadosLivro;
import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import com.portfolio.api_sboot_digital_library.service.LivroService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarLivro(@RequestBody @Valid DadosLivro dados, UriComponentsBuilder uriComponentsBuilder) {
        return service.cadastrarLivro(dados, uriComponentsBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarLivro(@RequestBody DadosLivro dados, @PathVariable Integer id) {
        return service.atualizarLivro(dados, id);
    }

    @GetMapping("/{categoria}")
    public ResponseEntity<List<DadosLivro>> buscarLivrosPorCategoria(@PathVariable Categoria categoria) {
        return service.buscarLivrosPorCategoria(categoria);
    }

    @PostMapping("/emprestimo/{idLivro}")
    @Transactional
    public ResponseEntity realizarEmprestimo(@RequestBody Integer idUsuario, @PathVariable Integer idLivro, UriComponentsBuilder uriComponentsBuilder) {
        return service.realizarEmprestimo(idUsuario, idLivro, uriComponentsBuilder);
    }
}
