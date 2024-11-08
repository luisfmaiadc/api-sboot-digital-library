package com.portfolio.api_sboot_digital_library.service;

import com.portfolio.api_sboot_digital_library.domain.endereco.DadosAtualizacaoEndereco;
import com.portfolio.api_sboot_digital_library.domain.endereco.DadosEnderecoAtualizado;
import com.portfolio.api_sboot_digital_library.domain.endereco.Endereco;
import com.portfolio.api_sboot_digital_library.domain.endereco.viaCepAPI;
import com.portfolio.api_sboot_digital_library.domain.users.DadosAtualizacaoUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.DadosCadastroUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.DadosUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import com.portfolio.api_sboot_digital_library.infra.exception.AgeException;
import com.portfolio.api_sboot_digital_library.repository.EnderecoRepository;
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

    @Autowired
    private EnderecoRepository enderecoRepository;

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
        verificaDadosAtualizacaoCadastro(dados, usuario);
        DadosAtualizacaoUsuario dadosUsuarioAtualizado = new DadosAtualizacaoUsuario(usuario);
        return ResponseEntity.ok(dadosUsuarioAtualizado);
    }

    public void verificaDadosAtualizacaoCadastro(DadosAtualizacaoUsuario dados, Usuario usuario) {
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

    public ResponseEntity atualizarEndereco(DadosAtualizacaoEndereco dados) {
        Endereco endereco = enderecoRepository.getReferenceById(dados.id());
        verificaDadosAtualizacaoEndereco(dados, endereco);
        DadosEnderecoAtualizado dadosEnderecoAtualizado = new DadosEnderecoAtualizado(endereco.getCep(), endereco.getLogradouro(),
                endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
        return ResponseEntity.ok(dadosEnderecoAtualizado);
    }

    public void verificaDadosAtualizacaoEndereco(DadosAtualizacaoEndereco dados, Endereco endereco) {
        if (dados.cep() != null) {
            viaCepAPI viaCepAPI = new viaCepAPI();
            Endereco novoEndereco = viaCepAPI.pesquisaEndereco(dados.cep(), dados.numero());
            endereco.setCep(novoEndereco.getCep());
            endereco.setLogradouro(novoEndereco.getLogradouro());
            endereco.setNumero(novoEndereco.getNumero());
            endereco.setBairro(novoEndereco.getBairro());
            endereco.setCidade(novoEndereco.getCidade());
            endereco.setEstado(novoEndereco.getEstado());
        }

        if (dados.numero() != null) {
            endereco.setNumero(dados.numero());
        }
    }
}
