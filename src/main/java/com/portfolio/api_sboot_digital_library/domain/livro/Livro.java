package com.portfolio.api_sboot_digital_library.domain.livro;

import com.portfolio.api_sboot_digital_library.domain.emprestimo.Emprestimo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "livro")
@Entity(name = "Livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean disponivel;

    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimo;
}
