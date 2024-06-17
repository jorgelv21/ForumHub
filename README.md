# Forum HUB

## Sobre

Esta é uma aplicação usada no curso de spring da Alura One Oracle.

Este repositório é uma aplicação BackEnd de criação de um sistema de forum com Assuntos, Posts, E um sistema de autenticação com criação de usuario e senha e autenticação aos endpoints através de um token de autenticação

## endpoints

```/usuario```  - Endpoint de criação. Acesso sem autenticação

```/authenticate``` - Endpoint para geração de um Bearer Token(necessário usuario e senha).

```/assunto``` - Endpoint de assuntos onde podemos buscar uma lista de assuntos, buscar um assunto por ID, criar um novo assunto, editar um assunto e deletar logicamente um assunto.

JSON Exemplo ```{"nome": "insira um nome"}```

```/post``` - Endpoint de posts onde podemos buscar uma lista de posts, buscar um post por ID, criar um novo post, editar um post e deletar um post logicamente.

JSON Exemplo ```{"titulo" : "insira um titulo", 
"texto" : "insira um texto, "assunto": {"id" : id de um assunto existente}}```

