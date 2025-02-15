# To-Do List em Java com Spring Boot

## Introdução

Este projeto é uma aplicação REST para gerenciamento de tarefas (To-do List) desenvolvida utilizando **Java** com o framework **Spring**. O objetivo é permitir que os usuários possam criar, listar, atualizar e deletar tarefas de forma simples e eficiente. A aplicação segue os princípios de desenvolvimento ágil e boas práticas de programação, utilizando a arquitetura MVC (Model-View-Controller).

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

- **src/main/java/com/ianfelps/todo_list**
    - **controller**: Contém as classes responsáveis por gerenciar as requisições HTTP e interagir com os serviços.
    - **entity**: Contém as classes que representam as entidades do banco de dados, mapeadas para tabelas.
    - **repository**: Contém as interfaces que gerenciam a persistência de dados, utilizando Spring Data JPA.
    - **service**: Contém as classes que implementam a lógica de negócio da aplicação.
    - **TodoListApplication.java**: Classe principal que inicia a aplicação Spring Boot.

- **src/test/java/com/ianfelps/todo_list**
    - **TodoListApplicationTests.java**: Contém os testes automatizados da aplicação, utilizando JUnit e Spring Test.

## Estrutura das Classes

### Todo

A classe `Todo` representa a entidade To-do e é mapeada para a tabela `todos` no banco de dados. Possui os seguintes atributos:

- `id`: Identificador único do To-do (chave primária).
- `nome`: Nome da tarefa (não pode ser vazio).
- `descricao`: Descrição da tarefa (não pode ser vazia).
- `realizado`: Indica se a tarefa foi concluída.
- `prioridade`: Nível de prioridade da tarefa (deve ser maior ou igual a zero).

### TodoApiController

A classe `TodoApiController` é responsável por gerenciar as requisições HTTP relacionadas aos To-dos via API. Os principais métodos incluem:

- `list()`: Retorna a lista de todos os To-dos.
- `create(Todo todo)`: Cria um novo To-do.
- `update(Long id, Todo todo)`: Atualiza um To-do existente.
- `delete(Long id)`: Deleta um To-do existente.

### TodoWebController - Em desenvolvimento...

A classe `TodoWebController` é responsável por gerenciar as requisições HTTP relacionadas aos To-dos via interface web. Os principais métodos incluem:

- `list()`: Retorna a lista de todos os To-dos.

### TodoService

A classe `TodoService` contém a lógica de negócio para manipulação dos To-dos. Os principais métodos incluem:

- `list()`: Lista todos os To-dos, ordenados por prioridade e ID.
- `create(Todo todo)`: Salva um novo To-do no repositório.
- `update(Long id, Todo todo)`: Atualiza um To-do existente.
- `delete(Long id)`: Remove um To-do do repositório.

### TodoRepository

A interface `TodoRepository` estende `JpaRepository`, fornecendo métodos prontos para operações CRUD (Create, Read, Update, Delete) na entidade To-do.

## Dependências

O projeto utiliza as seguintes dependências principais, definidas no arquivo `pom.xml`:

- **Spring Boot Starter Web**: Para construir aplicações web, incluindo suporte a RESTful APIs.
- **Spring Boot Starter Data JPA**: Para integração com bancos de dados usando JPA (Java Persistence API).
- **Spring Boot Starter Validation**: Para validação de dados de entrada.
- **MySQL Connector**: Para conexão com o banco de dados MySQL.
- **H2 Database**: Banco de dados em memória para testes e desenvolvimento.
- **Spring Boot DevTools**: Para facilitar o desenvolvimento com recarregamento automático.
- **Springdoc OpenAPI**: Para documentação Swagger da API, permitindo a visualização e teste dos endpoints.
- **Thymeleaf**: Para renderização de templates HTML.

## Interface Web - Em desenvolvimento...

A interface web da aplicação estã disponível no enderço padrão e apresenta a lista de todos os To-dos. Ela permite a criação, atualização e exclusão de tarefas.

## Endpoints da API

A aplicação expõe os seguintes endpoints:

- **GET /api**: Lista todos os To-dos.
- **POST /api**: Cria um novo To-do.
- **PUT /api/{id}**: Atualiza um To-do existente.
- **DELETE /api/{id}**: Deleta um To-do existente.

#### Documentação da API em Swagger: `http://localhost:8080/swagger-ui.html`

### Exemplo de Uso

#### Listar To-dos

```http
GET /api
```

#### Criar um To-do

```http
POST /api
Content-Type: application/json

{
  "nome": "Nome do To-do",
  "descricao": "Descrição do To-do.",
  "realizado": false,
  "prioridade": 1
}
```

#### Atualizar um To-do

```http
PUT /api/{id}
Content-Type: application/json

{
  "nome": "Nome do To-do Atualizado",
  "descricao": "Descrição do To-do Atualizada.",
  "realizado": true,
  "prioridade": 0
}
```

#### Deletar um To-do

```http
DELETE /api/{id}
```

## Testes Automatizados

Os testes automatizados estão implementados na classe `TodoListApplicationTests.java`. Eles garantem que as funcionalidades da aplicação estão funcionando conforme o esperado. Os principais testes incluem:

- `testCreateTodoSuccess()`: Testa a criação de um To-do com sucesso.
- `testCreateTodoFailure()`: Testa a criação de um To-do com falha.
- `testUpdateTodoSuccess()`: Testa a atualização de um To-do com sucesso.
- `testUpdateTodoFailure()`: Testa a atualização de um To-do com falha.
- `testDeleteTodoSuccess()`: Testa a exclusão de um To-do com sucesso.

## Como Executar o Projeto

Para executar o projeto "To-Do List" desenvolvido em Java com Spring Boot, siga os passos abaixo:

### Pré-requisitos

- **Java JDK 17**: Certifique-se de que o Java JDK 17 está instalado em sua máquina. Você pode verificar a instalação executando o comando:
  ```bash
  java -version
  ```

- **Maven**: Certifique-se de que o Maven esté instalado em sua máquina. Vocé pode verificar a instalação executando o comando:
  ```bash
  mvn -version
  ```

- **Banco de Dados**: Configure um banco de dados MySQL e crie um banco de dados para a aplicação.

### Passos para Executar

1. **Clone o Repositório**:
  Clone o repositório do projeto para sua máquina local:
  ```bash
  git clone https://github.com/ianfelps/todo_list.git
  cd todo_list
  ```

2. **Configurar o Banco de Dados**:
  Edite o arquivo `src/main/resources/application.properties` para configurar a conexão com o banco de dados MySQL:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update
  ```

3. **Compilar o Projeto**:
  Navegue até o diretório do projeto e execute o comando Maven para compilar o projeto:
  ```bash
  mvn clean install
  ```

4. **Executar a Aplicação**:
  Após a compilação bem-sucedida, você pode executar a aplicação com o seguinte comando:
  ```bash
  mvn spring-boot:run
  ```

5. **Acessar a Interface Web**:
  A interface web estará disponível em: `http://localhost:8080`. Vocé pode acessar a interface web para criar, editar e excluir To-dos de uma forma interativa e dinâmica.

6. **Acessar a API**:
  A API estará disponível em: `http://localhost:8080/api`. Você pode acessar os endpoints conforme descrito na seção de **Endpoints da API**.

7. **Documentação da API**:
  A documentação da API em Swagger pode ser acessada em: `http://localhost:8080/swagger-ui.html`

## Conclusão

Este projeto é uma demonstração de como construir uma API REST simples de gerenciamento de tarefas e foi uma excelente oportunidade de aprendizado permitindo-me aprofundar meus conhecimentos em Java, Spring, APIs REST, testes automatizados e boas práticas de desenvolvimento que tornem a aplicação mais fácil e entender e manter. Futuramente estarei implementando novas funcionalidades e uma integração com front-end para tornar a aplicação completa.