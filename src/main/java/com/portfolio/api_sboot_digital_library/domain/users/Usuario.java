package com.portfolio.api_sboot_digital_library.domain.users;

import com.portfolio.api_sboot_digital_library.domain.emprestimo.Emprestimo;
import com.portfolio.api_sboot_digital_library.domain.endereco.Endereco;
import com.portfolio.api_sboot_digital_library.domain.login.Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "users")
@Entity(name = "Usuario")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    private String telefone;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Login login;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimo;
}
