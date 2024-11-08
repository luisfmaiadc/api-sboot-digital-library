package com.portfolio.api_sboot_digital_library.domain.login;

import com.portfolio.api_sboot_digital_library.domain.users.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "login")
@Entity(name = "Login")
public class Login {

    @Id
    @Column(name = "id_usuario")
    private Integer id;

    private String email;
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
