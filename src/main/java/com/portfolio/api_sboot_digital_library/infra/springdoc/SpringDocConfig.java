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
                                <li><b>Cadastrar e Gerenciar Livros:</b></li> <p>Permite a inserção de novos livros, com informações completas como título, autor, editora, categoria, ISBN e disponibilidade. Além disso, é possível atualizar e listar essas informações, garantindo que os dados da biblioteca estejam sempre atualizados.</p>
                                <li><b>Gerenciar Usuários da Biblioteca:</b></li> <p>Possibilita o cadastro e a atualização dos dados de usuários, facilitando a identificação e o controle dos membros que utilizam a biblioteca. Isso permite gerenciar os dados de contato e histórico de empréstimos dos usuários.</p>
                                <li><b>Controlar Empréstimos de Livros:</b></li> <p>É possível realizar o empréstimo de livros para os usuários, com controle das datas de início e status do empréstimo. A funcionalidade verifica automaticamente a disponibilidade do livro e registra o empréstimo, proporcionando uma gestão eficiente do acervo.</p>
                                <li><b>Organizar Livros por Categorias:</b></li> <p>Permite que os livros sejam classificados em categorias, facilitando a busca e navegação. Essa funcionalidade ajuda os usuários a encontrarem facilmente os livros de interesse, organizando o acervo de forma intuitiva.</p>
                                <li><b>Consultar Histórico de Empréstimos:</b></li> <p>Possibilita visualizar o histórico de empréstimos de cada usuário, permitindo o controle detalhado do uso dos livros e do retorno dos mesmos ao acervo.</p>
                            </ul>
                            """)
                );
    }
}
