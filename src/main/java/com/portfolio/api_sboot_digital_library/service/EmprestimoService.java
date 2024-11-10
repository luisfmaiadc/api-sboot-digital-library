package com.portfolio.api_sboot_digital_library.service;

import com.portfolio.api_sboot_digital_library.domain.livro.DadosLivro;
import com.portfolio.api_sboot_digital_library.domain.livro.Livro;
import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import com.portfolio.api_sboot_digital_library.repository.EmprestimoRepository;
import com.portfolio.api_sboot_digital_library.repository.LivroRepository;
import com.portfolio.api_sboot_digital_library.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    public ResponseEntity<List<DadosLivro>> buscaHistoricoEmprestimo(Integer idUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
        var list = emprestimoRepository.findHistoricoEmprestimo(usuario.getId()).stream().map(DadosLivro::new).toList();
        return ResponseEntity.ok(list);
    }
}
