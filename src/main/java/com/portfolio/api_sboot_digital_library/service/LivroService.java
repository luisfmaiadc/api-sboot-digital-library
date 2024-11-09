package com.portfolio.api_sboot_digital_library.service;

import com.portfolio.api_sboot_digital_library.domain.emprestimo.DadosEmprestimo;
import com.portfolio.api_sboot_digital_library.domain.emprestimo.Emprestimo;
import com.portfolio.api_sboot_digital_library.domain.livro.Categoria;
import com.portfolio.api_sboot_digital_library.domain.livro.DadosLivro;
import com.portfolio.api_sboot_digital_library.domain.livro.Livro;
import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import com.portfolio.api_sboot_digital_library.infra.exception.UnavailableException;
import com.portfolio.api_sboot_digital_library.repository.EmprestimoRepository;
import com.portfolio.api_sboot_digital_library.repository.LivroRepository;
import com.portfolio.api_sboot_digital_library.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity cadastrarLivro(DadosLivro dados, UriComponentsBuilder uriComponentsBuilder) {
        Livro livro = new Livro(dados);
        livroRepository.save(livro);
        URI uri = uriComponentsBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    public ResponseEntity atualizarLivro(DadosLivro dados, Integer id) {
        Livro livro = livroRepository.getReferenceById(id);
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

    public ResponseEntity realizarEmprestimo(Integer idUsuario, Integer idLivro, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
        Livro livro = livroRepository.getReferenceById(idLivro);
        verificaLivroDisponivel(livro);
        livro.setDisponivel(false);
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimoRepository.save(emprestimo);
        URI uri = uriComponentsBuilder.path("/livro/emprestimo/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosEmprestimo(usuario, livro, emprestimo));
    }

    private void verificaLivroDisponivel(Livro livro) {
        if (!livro.getDisponivel()) {
            throw new UnavailableException("Livro informado já foi emprestado, retorne em alguns dias.");
        }
    }

    public ResponseEntity<List<DadosLivro>> buscarLivrosPorCategoria(Categoria categoria) {
        var list = livroRepository.findByCategoria(categoria).stream().map(DadosLivro::new).toList();
        return ResponseEntity.ok(list);
    }
}