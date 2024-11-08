package com.portfolio.api_sboot_digital_library.service;

import com.portfolio.api_sboot_digital_library.domain.livro.DadosLivro;
import com.portfolio.api_sboot_digital_library.domain.livro.Livro;
import com.portfolio.api_sboot_digital_library.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public ResponseEntity cadastrarLivro(DadosLivro dados, UriComponentsBuilder uriComponentsBuilder) {
        Livro livro = new Livro(dados);
        repository.save(livro);
        URI uri = uriComponentsBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    public ResponseEntity atualizarLivro(DadosLivro dados, Integer id) {
        Livro livro = repository.getReferenceById(id);
        verificaDadosAtualizacaoLivro(dados, livro);
        return ResponseEntity.ok(new DadosLivro(livro));
    }

    private void verificaDadosAtualizacaoLivro(DadosLivro dados, Livro livro) {
        if (dados.titulo() != null) {
            livro.setTitulo(dados.titulo());
        }

        if (dados.autor() != null) {
            livro.setAutor(dados.autor());
        }

        if (dados.editora() != null) {
            livro.setEditora(dados.editora());
        }

        if (dados.isbn() != null) {
            livro.setIsbn(dados.isbn());
        }

        if (dados.categoria() != null) {
            livro.setCategoria(dados.categoria());
        }
    }
}
