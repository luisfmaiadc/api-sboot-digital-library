package com.portfolio.api_sboot_digital_library.service;

import com.portfolio.api_sboot_digital_library.domain.endereco.Endereco;
import com.portfolio.api_sboot_digital_library.domain.endereco.viaCepAPI;
import com.portfolio.api_sboot_digital_library.domain.users.DadosCadastroUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.DadosUsuario;
import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import com.portfolio.api_sboot_digital_library.repository.EnderecoRepository;
import com.portfolio.api_sboot_digital_library.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity cadastrarUsuario(DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = new Usuario(dados);
        viaCepAPI viaCepAPI = new viaCepAPI();
        Endereco endereco = viaCepAPI.pesquisaEndereco(dados.cep(), dados.numero());
        endereco.setUsuario(usuario);
        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosUsuario(usuario, endereco));
    }
}
