# 🎮 GamesList REST API

API REST construída com **Java** e **Spring Boot** para gerenciamento de uma lista de jogos. Este projeto foi desenvolvido como parte do aprendizado no **Intensivão Java Spring** do professor [Nélio Alves](https://github.com/nelioalves).

---

## ✨ Funcionalidades

- 🔹 Listar todas as categorias de jogos.
- 🔹 Listar jogos com base em uma categoria.
- 🔹 Listar todos os jogos.
- 🔹 Reposicionar (ordenar) os jogos de uma determinada categoria.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database** (ambiente de desenvolvimento)
- **PostgreSQL** (produção/testes)
- **Docker Compose** (para facilitar a configuração do ambiente)

---

## 🧪 Como Executar o Projeto

### ✅ Pré-requisitos

- Java 21+
- Maven
- Docker (opcional)
- PostgreSQL (local ou via container)

### 🔄 Rodando com Docker Compose

Você pode levantar o banco PostgreSQL e o PGAdmin usando o seguinte arquivo `docker-compose.yml`:

```yaml
version: "3.7"

services:
  pg-docker:
    image: postgres:14-alpine
    container_name: dev-postgresql
    environment:
      POSTGRES_DB: mydatabase
      POSTGRES_PASSWORD: 1234567
    ports:
      - 5433:5432
    volumes:
      - ./.data/postgresql/data:/var/lib/postgresql/data
    networks:
      - dev-network

  pgadmin-docker:
    image: dpage/pgadmin4
    container_name: dev-pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: me@example.com
      PGADMIN_DEFAULT_PASSWORD: 1234567
    ports:
      - 5050:80
    volumes:
      - pgadmin_data:/var/lib/pgadmin
    depends_on:
      - pg-docker
    networks:
      - dev-network

networks:
  dev-network:
    driver: bridge

volumes:
  pg_data:
  pgadmin_data:
```
Para Subir Os Conteiner Use:

```bash
docker-compose up -d
```

---

## ⚙️ Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/Jefferson-Matheus/gameList.git://github.com/Jefferson-Matheus/gameList.git
   ```
### 2. Abra na sua IDE de preferência

Pode ser IntelliJ IDEA, VS Code, Eclipse ou outra de sua escolha.

---

## 🔁 Perfis de Ambiente

Este projeto permite execução em diferentes perfis: `test`, `dev` e `prod`.  
A configuração do perfil pode ser feita no arquivo `application.properties`:

```properties
spring.application.name=gameList
spring.profiles.active=${APP_PROFILE:test}
spring.jpa.open-in-view=false

cors.origins=${CORS_ORIGINS:http://localhost:5173,http://localhost:3000}
```

---

## 📡 Endpoints da API

### 🎮 Jogos (`/games`)

| Método | Endpoint            | Descrição                            |
|--------|---------------------|--------------------------------------|
| GET    | `/games`            | Retorna todos os jogos               |
| GET    | `/games/{id}`       | Retorna os detalhes de um jogo por ID |

---

### 🗂️ Listas de Categorias (`/lists`)

| Método | Endpoint                        | Descrição                                                |
|--------|----------------------------------|----------------------------------------------------------|
| GET    | `/lists`                        | Retorna todas as listas de categorias                    |
| GET    | `/lists/{listId}/games`         | Retorna os jogos associados a uma determinada lista      |
| POST   | `/lists/{listId}/replacement`   | Reposiciona a ordem dos jogos de uma lista específica    |
