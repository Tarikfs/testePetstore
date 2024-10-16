# Projeto de Testes Automatizados - Petstore API

Este projeto tem como objetivo avaliar sua capacidade técnica no desenvolvimento de testes automatizados utilizando a API da Petstore. Os testes devem garantir a validação do status code, da estrutura da resposta e dos valores dos dados retornados pela API.

## API de Teste

A API utilizada para este projeto é a [Petstore API](https://petstore.swagger.io/).

## Requisitos do Projeto

Os seguintes casos de teste devem ser implementados:

1. **Cadastrar novo pedido de pet com sucesso**
   - **Método:** POST
   - **Endpoint:** `/store/order`
   - **Descrição:** Este teste deve verificar se um novo pedido de pet pode ser cadastrado com sucesso.

2. **Pesquisar por um pet inexistente**
   - **Método:** GET
   - **Endpoint:** `/pet/{petId}`
   - **Descrição:** Este teste deve validar a resposta ao buscar um pet que não existe, garantindo que o status code e a mensagem de erro sejam apropriados.

3. **Atualizar dados de um pet existente**
   - **Método:** PUT
   - **Endpoint:** `/pet`
   - **Descrição:** Este teste deve verificar se os dados de um pet existente podem ser atualizados corretamente.

4. **Pesquisar por pets com status “pending”**
   - **Método:** GET
   - **Endpoint:** `/pet/findByStatus`
   - **Descrição:** Este teste deve garantir que a pesquisa retorne corretamente todos os pets com status "pending".

## Padrão do Projeto

- **Linguagem de Programação:** Java
- **Biblioteca Utilizada:** RestAssured

## Instruções para Execução
