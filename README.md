# Controle de Estoque

Este é um projeto simples de controle de estoque desenvolvido em **Java** com o framework **Spring Boot**. O objetivo é gerenciar diferentes tipos de produtos (Camisas, Tênis e Vapes), cada um com suas especificações distintas.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot 3**: Framework para criar aplicações Java robustas.
  - Spring Data JPA para persistência de dados.
  - Spring Web para criação de APIs RESTful.
- **H2 Database**: Banco de dados em memória para testes e desenvolvimento.
- **Maven**: Gerenciador de dependências.
- **Jakarta Persistence API (JPA)**: Para mapeamento de entidades.

## Funcionalidades

- Cadastro de produtos com diferentes atributos específicos:
  - **Camisas**: Tamanho, cor.
  - **Tênis**: Tamanho, cor.
  - **Vapes**: Quantidade puffs, sabor.
- Consulta de produtos cadastrados.
- Atualização e exclusão de produtos.
- Organização por tipo de produto em tabelas separadas no banco de dados.

## Estrutura do Projeto

O projeto utiliza uma hierarquia de classes para representar os produtos:

- **`Produto`**: Classe abstrata que contém os atributos comuns a todos os produtos.
- **Subclasses**:
  - `Camisa`
  - `Tenis`
  - `Vape`
