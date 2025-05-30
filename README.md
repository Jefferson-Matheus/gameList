# GamesList REST API

API Construida Com Java E Spring Boot Para Listagem De Jogos. As Funcionalidades Incluem:

1. Listar Categorias De Jogos
2. Listar Jogos Com Base Na Categoria
3. Listar Todos Os Jogos
4. Reposicionar Jogos De Uma Determinada Categoira

Projeto Feito Para Aprendizando Durante O Intensivão Java Spring Do professor Nélio Alves.

# Tecnologias Utilizadas

1. Java 21
2. Spring Boot 3.4.5
3. Spring JPA
4. Spring Web
5. H2
6. PostgreSQL


É Possivel Testar A API Com Um Banco De Dados PosgreSQL Instaldo Na Maquina Ou Via Docker Compose com um Aquivo .yml

```bash
  version: "3.7"
services:
  # ====================================================================================================================
  # POSTGRES SERVER
  # ====================================================================================================================
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
  # ====================================================================================================================
  # PGADMIN
  # ====================================================================================================================
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
# ======================================================================================================================
# REDE
# ======================================================================================================================
networks:
  dev-network:
    driver: bridge
    
    
---

# ======================================================================================================================
# VOLUMES NOMEADOS
# ======================================================================================================================
volumes:
  pg_data:
  pgadmin_data:
```
