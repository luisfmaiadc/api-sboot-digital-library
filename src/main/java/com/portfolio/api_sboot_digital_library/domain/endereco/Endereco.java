package com.portfolio.api_sboot_digital_library.domain.endereco;

import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "endereco")
@Entity(name = "Endereco")
public class Endereco {

    @Id
    @Column(name = "id_usuario")
    private Integer id;

    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
