package com.portfolio.api_sboot_digital_library.domain.emprestimo;

import com.portfolio.api_sboot_digital_library.domain.livro.Livro;
import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "emprestimo")
@Entity(name = "Emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro")
    private Livro livro;

    @Column(name = "data_emprestimo")
    private LocalDateTime dataEmprestimo = LocalDateTime.now();

    private String status = "ativo";

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }
}
