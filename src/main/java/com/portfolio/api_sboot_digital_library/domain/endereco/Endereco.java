package com.portfolio.api_sboot_digital_library.domain.endereco;

import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "endereco")
@Entity
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

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Endereco(viaCepEndereco viaCepEndereco, String numero) {
        this.cep = viaCepEndereco.cep().replace("-", "");
        this.logradouro = viaCepEndereco.logradouro();
        this.numero = numero;
        this.bairro = viaCepEndereco.bairro();
        this.cidade = viaCepEndereco.localidade();
        this.estado = viaCepEndereco.uf();
    }
}
