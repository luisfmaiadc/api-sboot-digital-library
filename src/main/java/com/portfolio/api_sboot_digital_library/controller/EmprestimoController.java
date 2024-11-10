package com.portfolio.api_sboot_digital_library.controller;

import com.portfolio.api_sboot_digital_library.domain.livro.DadosLivro;
import com.portfolio.api_sboot_digital_library.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping("/{idUsuario}/historico")
    public ResponseEntity<List<DadosLivro>> buscaHistoricoEmprestimo(@PathVariable Integer idUsuario) {
        return service.buscaHistoricoEmprestimo(idUsuario);
    }
}
