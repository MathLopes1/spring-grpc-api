# API gRPC com Spring Boot

## Introdução

Este é um guia para a API gRPC construída utilizando Spring Boot como framework e gRPC como adaptador de comunicação entre serviços.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construção de aplicações Java.
- **gRPC**: Sistema de chamada remota de procedimento (RPC) de alto desempenho.
- **Protocol Buffers (Protobuf)**: Formato de serialização de dados utilizado pelo gRPC.

## Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- Java Development Kit (JDK)
- Maven

## Operações Suportadas

A API suporta as seguintes operações:

### Chamadas de Procedimento Remoto (RPC)

- **create**: Cria um novo usuário.
- **getAll**: Retorna todos os usuários cadastrados.
- **getAllServerStream**: Retorna uma transmissão de todos os usuários cadastrados no servidor.

## Definições do Protocolo gRPC (Proto)

```protobuf
service UserService {
  rpc create(UserReq) returns (UserRes) {}
  rpc getAll(EmptyReq) returns (UserResList) {}
  rpc getAllServerStream(EmptyReq) returns (stream UserRes) {}
}

message EmptyReq {}

message UserReq {
  string name = 1;
  string email = 2;
}

message UserRes {
  int64 id = 1;
  string name = 2;
  string email = 3;
}

message UserResList {
  repeated UserRes users = 1;
}
