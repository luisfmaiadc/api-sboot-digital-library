package com.portfolio.api_sboot_digital_library.domain.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosLivro(@NotBlank String titulo, @NotBlank String autor, @NotBlank String editora,
                         @NotBlank String isbn, @NotNull Categoria categoria) {

    public DadosLivro(Livro livro) {
        this(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getIsbn(), livro.getCategoria());
    }
}
