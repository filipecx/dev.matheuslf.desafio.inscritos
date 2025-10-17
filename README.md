## 🧠 Desafio Técnico – Sistema de Gestão de Projetos e Demandas

Decidi aproveitar esse desafio pra aplicar algumas coisas que estou estudando enquanto busco minha primeira oportunidade na área.
Por isso, algumas coisas provavelmente foram feitas de maneira mais complexa do que precisavam 😄

Foi uma oportunidade muito legal também pra conhecer Bean Validations, MapStruct, Swagger, e um pouco de testes e os mocks. Não fiz todos os testes porque já tava me enrolando, e nossa, quanto trabalho dá!

Como o MapStruct tava dando uma cofusão com o padrão builder, que decidi usar um pouco pra aprender, alguns mapeamentos fiz na mão.

O projeto não tem autenticação!

Sem mais delongas...
Pré-requisitos

Docker
Docker Compose

---

# Meu Projeto Spring Boot + PostgreSQL (Docker)

Este projeto é uma **API REST em Spring Boot** com banco **PostgreSQL**, configurada para **rodar em desenvolvimento usando Docker e Docker Compose**. Feito para o desafio idealizado por Matheus Leandro Ferreita (Obrigado Matheus!).

---

## Pré-requisitos

* [Docker](https://www.docker.com/get-started) instalado
* [Docker Compose](https://docs.docker.com/compose/install/)
* Sistema operacional: Windows, Linux ou macOS (funciona com WSL2 no Windows)

---

## Como rodar

1. Abra o terminal na raiz do projeto.

2. Execute:

```bash
docker compose up --build
```

* Isso fará:

  * Baixar as imagens do PostgreSQL e Maven + JDK 17 (se ainda não estiverem localmente)
  * Construir a imagem da API Spring Boot
  * Criar e iniciar os containers do banco e da API
  * Sincronizar seu código local com o container (ideal para desenvolvimento)

3. Acesse:

* API: [http://localhost:8080](http://localhost:8080)
* Swagger: http://localhost:8080/swagger-ui.html
* Banco PostgreSQL: localhost:5432 (usuário: `postgres`, senha: `postgres`)

---

## Configurações do banco

As variáveis de conexão estão definidas no `docker-compose.yml`:

```yaml
environment:
  SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/manager
  SPRING_DATASOURCE_USERNAME: postgres
  SPRING_DATASOURCE_PASSWORD: postgres
```

O **Hibernate** criará/atualizará as tabelas automaticamente.

### Abaixo, o conteúdo original do readme.
### 📘 Contexto
Sua missão é desenvolver uma **API RESTful em Java com Spring Boot** para gerenciar **projetos e tarefas (demandas)** de uma empresa.  
O sistema será utilizado por um time de desenvolvimento para organizar suas entregas, acompanhar o status das tarefas e realizar análises simples.

---

## 🎯 Requisitos Técnicos

### 🧱 1. Modelagem de Domínio

A modelagem pode ser modificada pelo inscrito. Porém, precisa ser justificado o motivo.

#### `Project`
| Campo | Tipo | Descrição |
|-------|------|-----------|
| `id` | UUID/Long | Identificador |
| `name` | String (3–100) | **Obrigatório** |
| `description` | String | Opcional |
| `startDate` | Date | Início do projeto |
| `endDate` | Date | Opcional |

#### `Task`
| Campo | Tipo | Descrição |
|-------|------|-----------|
| `id` | UUID/Long | Identificador |
| `title` | String (5–150) | **Obrigatório** |
| `description` | String | Detalhes da tarefa |
| `status` | Enum | TODO / DOING / DONE |
| `priority` | Enum | LOW / MEDIUM / HIGH |
| `dueDate` | Date | Data limite |
| `projectId` | FK(Project) | Relacionamento |

---

### 🌐 2. Endpoints REST

| Método | Endpoint | Descrição |
|---------|-----------|-----------|
| **POST** | `/projects` | Criar novo projeto (`name` obrigatório) |
| **GET** | `/projects` | Listar todos os projetos (paginação opcional) |
| **POST** | `/tasks` | Criar nova tarefa vinculada a um projeto |
| **GET** | `/tasks?status=&priority=&projectId=` | Buscar tarefas com filtros opcionais |
| **PUT** | `/tasks/{id}/status` | Atualizar apenas o status da tarefa |
| **DELETE** | `/tasks/{id}` | Remover tarefa |

---

## ✅ Requisitos Obrigatórios
- 🧑‍💻 **Java 17+** e **Spring Boot 3+**  
- 🧠 **Spring Data JPA**  
- 🗄️ Banco Relacional (**PostgreSQL** ou **H2**)  
- ✔️ **Bean Validation**  
- 🧪 **Testes Automatizados**  
  - Unitários (Services mockados)  
  - Integração (Controllers com MockMvc ou Testcontainers)  
- ⚠️ Tratamento de erros com `@ControllerAdvice`  
- 📦 Uso de **DTOs** (`record` ou classes simples)  
- 📘 **README** explicando como rodar o projeto

---

## 🏅 Diferenciais (Pontos Extras)
- 🧭 Documentação **Swagger / OpenAPI**  
- 🔐 Autenticação simples com **JWT** ou Basic Auth  
- 🐳 Configuração de **Docker** / **docker-compose**  
- ⚡ Uso de **MapStruct** para mapeamento de DTOs  
- 🔍 Testes de API com **RestAssured**

---

## 🛠️ Tags
`#Java` `#SpringBoot` `#Backend` `#DesafioTecnico`  
`#API` `#RestAPI` `#Docker` `#Kubernetes`  
`#PostgreSQL` `#Oracle` `#JPA` `#Swagger`  
`#RestAssured` `#CleanCode` `#SoftwareEngineering`

---

### 💡 Dica
> Foque em **organização, boas práticas e clareza do código**.  
> Um bom README e commits bem descritos também serão avaliados. 😉

---

### 🧾 Licença
Este projeto foi desenvolvido exclusivamente para o **processo seletivo SIS Innov & Tech** e não deve ser utilizado para fins comerciais.

---
