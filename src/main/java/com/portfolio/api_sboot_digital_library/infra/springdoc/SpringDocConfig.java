package com.portfolio.api_sboot_digital_library.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Digital Library REST API")
                        .description("""
                            A Digital Library REST API oferece um conjunto de funcionalidades essenciais para gerenciar uma biblioteca de forma prática e eficiente. Com ela, é possível: \n
                            <ul>
                                <li><b>Cadastrar e Gerenciar Livros</b></li> <p>Permite a inserção de novos livros, com informações completas como título, autor, editora, categoria, ISBN e disponibilidade. Além disso, é possível atualizar essas informações./p>
                                <li><b>Cadastrar e Gerenciar Usuários da Biblioteca</b></li> <p>Possibilita o cadastro e a atualização dos dados de usuários, facilitando a identificação e o controle dos membros que utilizam a biblioteca.</p>
                                <li><b>Cadastrar e Gerenciar Empréstimos de Livros</b></li> <p>É possível realizar o empréstimo de livros para os usuários, com controle das datas de início e status do empréstimo. A funcionalidade verifica automaticamente a disponibilidade do livro e registra o empréstimo.</p>
                            </ul>
                            """)
                );
    }
}
