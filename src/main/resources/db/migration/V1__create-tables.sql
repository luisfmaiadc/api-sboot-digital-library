CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(150) NOT NULL,
  data_nascimento DATE NOT NULL,
  data_cadastro DATE NOT NULL,
  telefone VARCHAR(20),
  PRIMARY KEY (id)
  );

CREATE TABLE endereco (
  id_usuario INT NOT NULL,
  cep VARCHAR(8) NOT NULL,
  logradouro VARCHAR(100) NOT NULL,
  numero VARCHAR(5) NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  estado VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_usuario),
  FOREIGN KEY (id_usuario) REFERENCES users(id)
  );

CREATE TABLE livro (
  id INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(150) NOT NULL,
  autor VARCHAR(150),
  editora VARCHAR(100) NOT NULL,
  isbn VARCHAR(20) UNIQUE NOT NULL,
  categoria VARCHAR(100) NOT NULL,
  disponivel TINYINT NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE emprestimo (
  id INT NOT NULL AUTO_INCREMENT,
  id_livro INT NOT NULL,
  id_usuario INT NOT NULL,
  data_emprestimo TIMESTAMP NOT NULL,
  status VARCHAR(20) DEFAULT 'ativo',
  PRIMARY KEY (id),
  FOREIGN KEY (id_livro) REFERENCES livro(id),
  FOREIGN KEY (id_usuario) REFERENCES users(id)
  );