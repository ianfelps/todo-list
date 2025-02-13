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

### TodoController

A classe `TodoController` é responsável por gerenciar as requisições HTTP relacionadas aos To-dos. Os principais métodos incluem:

- `list()`: Retorna a lista de todos os To-dos.
- `create(Todo todo)`: Cria um novo To-do.
- `update(Long id, Todo todo)`: Atualiza um To-do existente.
- `delete(Long id)`: Deleta um To-do existente.

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

## Configuração do Banco de Dados

A configuração do banco de dados deve ser feita no arquivo `application.properties`. Um exemplo de configuração para o MySQL é:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Endpoints da API

A aplicação expõe os seguintes endpoints:

- **GET /todos**: Lista todos os To-dos.
- **POST /todos**: Cria um novo To-do.
- **PUT /todos/{id}**: Atualiza um To-do existente.
- **DELETE /todos/{id}**: Deleta um To-do existente.

#### Documentação da API em Swagger: `http://localhost:8080/swagger-ui.html`

### Exemplo de Uso

#### Listar To-dos

```http
GET /todos
```

#### Criar um To-do

```http
POST /todos
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
PUT /todos/{id}
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
DELETE /todos/{id}
```

## Testes Automatizados

Os testes automatizados estão implementados na classe `TodoListApplicationTests.java`. Eles garantem que as funcionalidades da aplicação estão funcionando conforme o esperado. Os principais testes incluem:

- `testCreateTodoSuccess()`: Testa a criação de um To-do com sucesso.
- `testCreateTodoFailure()`: Testa a criação de um To-do com falha.
- `testUpdateTodoSuccess()`: Testa a atualização de um To-do com sucesso.
- `testUpdateTodoFailure()`: Testa a atualização de um To-do com falha.
- `testDeleteTodoSuccess()`: Testa a exclusão de um To-do com sucesso.

## Conclusão

Este projeto é uma demonstração de como construir uma API REST simples de gerenciamento de tarefas e foi uma excelente oportunidade de aprendizado permitindo-me aprofundar meus conhecimentos em Java, Spring, APIs REST, testes automatizados e boas práticas de desenvolvimento que tornem a aplicação mais fácil e entender e manter. Futuramente estarei implementando novas funcionalidades e uma integração com front-end para tornar a aplicação completa.