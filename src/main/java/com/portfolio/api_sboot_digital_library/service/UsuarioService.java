package com.portfolio.api_sboot_digital_library.service;

import com.portfolio.api_sboot_digital_library.domain.endereco.Endereco;
import com.portfolio.api_sboot_digital_library.domain.endereco.viaCepAPI;
import com.portfolio.api_sboot_digital_library.domain.users.DadosAtualizacaoUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.DadosCadastroUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.DadosUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import com.portfolio.api_sboot_digital_library.infra.exception.AgeException;
import com.portfolio.api_sboot_digital_library.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.Period;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity cadastrarUsuario(DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
        isAdult(dados.dataNascimento());
        viaCepAPI viaCepAPI = new viaCepAPI();
        Endereco endereco = viaCepAPI.pesquisaEndereco(dados.cep(), dados.numero());
        Usuario usuario = new Usuario(dados);
        endereco.setUsuario(usuario);
        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosUsuario(usuario, endereco));
    }

    public void isAdult(LocalDate dataNascimento) {
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new AgeException("Idade insuficiente para fazer uma reserva.");
        }
    }

    public ResponseEntity atualizarUsuario(DadosAtualizacaoUsuario dados) {
        Usuario usuario = usuarioRepository.getReferenceById(dados.id());
        verificaDadosAtualizacao(dados, usuario);
        DadosAtualizacaoUsuario dadosUsuarioAtualizado = new DadosAtualizacaoUsuario(usuario);
        return ResponseEntity.ok(dadosUsuarioAtualizado);
    }

    public void verificaDadosAtualizacao(DadosAtualizacaoUsuario dados, Usuario usuario) {
        if (dados.nome() != null) {
            usuario.setNome(dados.nome());
        }

        if (dados.dataNascimento() != null) {
            isAdult(dados.dataNascimento());
            usuario.setDataNascimento(dados.dataNascimento());
        }

        if (dados.telefone() != null) {
            usuario.setTelefone(dados.telefone());
        }
    }
}
