# LibraryApp
Sistema Library App criado para avaliação da disciplina Backend da Unit-PE
Grupo: Alan Ramos, Tiago Novaes e Thifany Souza
# API de Gerenciamento de Vendas de Livraria

![Image]([https://media.cntraveler.com/photos/5edf98c162bb344a7a7bab53/16:9/w_2560%2Cc_limit/SistersUptownBooks-NYC-WTJ2W3.jpg])

Bem-vindo à API de Gerenciamento de Vendas de Livraria! Esta API foi desenvolvida para auxiliar livrarias na gestão de suas vendas e estoques. Ela é integrada a uma API externa de busca de livros pelo ISBN, proporcionando uma experiência completa e eficiente para os usuários.

## Características Principais

- **Gerenciamento de Vendas**: A API permite cadastrar vendas, registrar os produtos vendidos, e atualizar o estoque automaticamente.

- **Busca de Livros por ISBN**: A API consome uma API externa para buscar detalhes de livros com base no ISBN, fornecendo informações completas sobre os produtos.

- **Cadastro de Clientes**: Os clientes podem ser cadastrados e vinculados às vendas, facilitando o histórico de compras e permitindo uma análise mais detalhada do perfil dos consumidores.


## Endpoints

A API de Gerenciamento de Vendas de Livraria possui os seguintes endpoints:

### `GET /acervo/:isbn`

Este endpoint é utilizado para buscar informações detalhadas sobre um livro através do seu ISBN. Ao realizar a chamada, a API consome a API externa de busca de livros pelo ISBN, retornando as seguintes informações:

```json
{
  "titulo": "Título do Livro",
  "autor": "Autor do Livro",
  "genero": "Gênero do Livro",
  "editora": "Editora do Livro",
  "ano_publicacao": "Ano de Publicação do Livro"
}
```

### `POST /books`

Este endpoint é utilizado para cadastrar uma nova venda. Ao fazer uma requisição para este endpoint, os seguintes parâmetros devem ser fornecidos:

```json
{
  "id": "Id da transação gerada automaticamente",
  "isbn": "código isbn do livro",
  "price": "preço do livro",
  "sale": "se o livro está (True) ou não (False) em promoção"
}
```

### `GET /books`

Este endpoint é utilizado para verificar todoas as transações registradas. Ao realizar a chamada, a API retorna a seguinte informação:

```json
{
  "id": "Id da transação gerada automaticamente",
  "isbn": "código isbn do livro",
  "price": "preço do livro",
  "sale": "se o livro está (True) ou não (False) em promoção"
}
```

### `PUT /books/:id`

Este endpoint é utilizado para atualizar uma transação pelo código do id. A API retorna as seguintes informações:

```json
{
  "id": "Id da transação gerada automaticamente",
  "isbn": "código isbn do livro",
  "price": "preço do livro",
  "sale": "se o livro está (True) ou não (False) em promoção"
}
```

### `DELETE /books/:id`

Este endpoint é utilizado para deletar uma transação pelo código do id. A API deleta as seguintes informações:

```json
{
  "id": "Id da transação gerada automaticamente",
  "isbn": "código isbn do livro",
  "price": "preço do livro",
  "sale": "se o livro está (True) ou não (False) em promoção"
}
```
