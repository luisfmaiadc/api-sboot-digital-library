package com.portfolio.api_sboot_digital_library.domain.users;

import com.portfolio.api_sboot_digital_library.domain.emprestimo.Emprestimo;
import com.portfolio.api_sboot_digital_library.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimo;

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.dataCadastro = LocalDate.now();
        this.telefone = dados.telefone();
    }
}
