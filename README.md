<h1 align="center">Biblioteca Digital - API REST SpringBoot</h1>
<p align="center">
 <a href="#started">Começando</a> • 
  <a href="#cloning">Clonando</a> •
 <a href="#creating">Banco de Dados</a> •
 <a href="#routes">API Endpoints</a> •
 <a href="#colab">Colaboradores</a>
</p>

<p align="center" style="margin-bottom: 20;">
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
    <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring" />
    <img src="https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />
    <img src="https://img.shields.io/badge/Flyway-CC0200.svg?style=for-the-badge&logo=Flyway&logoColor=white" alt="Flyway" />
    <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" alt="Hibernate" />
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Apache Maven" />
</p>

<p style="text-align: justify;">Este projeto é uma API REST desenvolvida com Spring Boot 3.3.5 e Java 21 para gerenciar uma Biblioteca Digital. A API oferece funcionalidades para cadastro e gerenciamento de livros, controle de usuários, realização de empréstimos, organização por categorias e consulta de histórico de empréstimos. No cadastro de endereços dos usuários, a integração com a API externa ViaCEP permite que o usuário insira apenas o CEP e o número da residência, automatizando o preenchimento dos demais campos de endereço. Os dados são armazenados em um banco de dados MySQL, com a gestão de versionamento e migrações realizadas pelo Flyway. A documentação dos endpoints é gerada automaticamente pelo SpringDoc, facilitando o acesso e o entendimento das rotas e operações disponíveis na API.</p>
<h2 id="started">🚀 Começando</h2>

Antes de começar, verifique se você possui as seguintes ferramentas instaladas em sua máquina:

- [Java](https://www.oracle.com/java/technologies/downloads/#java22)
- [MySQL](https://dev.mysql.com/downloads/installer/)

<h2 id="cloning">👾 Clonando</h2>

Como clonar o projeto:
```bash
git@github.com:luisfmaiadc/api-sboot-digital-library.git
```

<h2 id="creating">💾 Criando Banco de Dados</h2>
<p style="margin-bottom: 20;">Para que o projeto funcione corretamente, é necessário criar um banco de dados MySQL com o nome <i>dbLivraria</i> a partir do comando abaixo:</p>


```SQL
CREATE DATABASE dbLivraria;
```

<p style="margin-top: 20;">Não é necessário se preocupar com a criação das tabelas manualmente, pois estou utilizando o Flyway para gerenciar as migrações do banco de dados. Assim, ao rodar o projeto, as tabelas serão criadas automaticamente.</p>

A tabela <i>users</i> deve conter os seguintes campos:

- <b>id:</b> chave primária, auto-incrementada pelo banco de dados
- <b>nome:</b> campo de texto (String) com até 150 caracteres
- <b>data_nascimento:</b> campo do tipo DATE
- <b>data_cadastro:</b> campo do tipo DATE
- <b>telefone:</b> campo de texto (String) com até 20 caracteres

A tabela <i>endereco</i> deve conter os seguintes campos:

- <b>id_usuario:</b> chave primária e estrangeira que referencia o campo id da tabela users
- <b>cep:</b> campo de texto (String) com 8 caracteres
- <b>logradouro:</b> campo de texto (String) com até 100 caracteres
- <b>numero:</b> campo de texto (String) com até 5 caracteres
- <b>bairro:</b> campo de texto (String) com até 50 caracteres
- <b>cidade:</b> campo de texto (String) com até 100 caracteres
- <b>estado:</b> campo de texto (String) com até 50 caracteres

A tabela <i>livro</i> deve conter os seguintes campos:

- <b>id:</b> chave primária, auto-incrementada pelo banco de dados
- <b>titulo:</b> campo de texto (String) com até 150 caracteres
- <b>autor:</b> campo de texto (String) com até 150 caracteres
- <b>editora:</b> campo de texto (String) com até 100 caracteres
- <b>isbn:</b> campo de texto único (String) com até 20 caracteres
- <b>categoria:</b> campo de texto (String) com até 100 caracteres
- <b>disponivel:</b> campo do tipo TINYINT, que indica a disponibilidade do livro (0 para indisponível, 1 para disponível)

A tabela <i>emprestimo</i> deve conter os seguintes campos:

- <b>id:</b> chave primária, auto-incrementada pelo banco de dados
- <b>id_livro:</b> chave estrangeira que referencia o campo id da tabela livro
- <b>id_usuario:</b> chave estrangeira que referencia o campo id da tabela users
- <b>data_emprestimo:</b> campo do tipo TIMESTAMP
- <b>status:</b> campo de texto (String) com até 20 caracteres

<h2 id="routes">📍 API Endpoints</h2>

Ao iniciar o projeto, a biblioteca SpringDoc, integrada à aplicação, facilita a visualização e a interação com todos os endpoints disponíveis. Ela exibe as informações detalhadas sobre cada endpoint, incluindo os formatos esperados para as requests e responses, permitindo uma experiência de uso prática e intuitiva para o desenvolvedor.

Para acessar a documentação interativa, utilize os seguintes links:

- [Swagger UI](http://localhost:8080/swagger-ui/index.html#/): interface gráfica que permite explorar e testar os endpoints.
- [API Docs JSON](http://localhost:8080/v3/api-docs): documentação em formato JSON para integração e consulta.

<h2 id="colab">🤝 Colaboradores</h2>
<p style="margin-bottom: 20;">Este projeto foi desenvolvido com o objetivo de aprimorar minhas habilidades com Spring Boot, especialmente ao trabalhar com tabelas de relacionamentos mais complexas. Foi minha segunda experiência na criação de uma API REST em Java, e proporcionou um aprendizado aprofundado que contribuiu significativamente para meu desenvolvimento como programador.</p>
<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/168129517?v=4&size=64" width="100px;" alt="Luis Felipe Maia da Costa Profile Picture"/><br>
        <sub>
          <b>Luis Felipe Maia da Costa</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
