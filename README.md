# Online Voting System - Microservices

A production-style **Online Voting System** built with **Spring Boot microservices**.  
The project demonstrates secure authentication, API gateway routing, service discovery, asynchronous event-driven communication, API documentation, and containerized deployment.

## Overview

This platform is split into independent services:

- **auth-service**: User registration/login and JWT generation/validation
- **election-service**: Election and candidate management, vote tally consumption
- **vote-service**: Vote casting and result publishing
- **api-gateway**: Single entry point, request routing, JWT filter
- **service-reg**: Eureka service registry

## Key Features

- JWT-based authentication and protected APIs
- Spring Cloud API Gateway routing
- Eureka service discovery integration
- Asynchronous inter-service communication using RabbitMQ
  - `vote-service` publishes vote events
  - `election-service` consumes events and updates tally
- OpenAPI/Swagger documentation (including centralized gateway docs)
- MySQL persistence (H2 for test profile)
- Full Dockerized setup with Docker Compose

## Tech Stack

- Java 17
- Spring Boot (Web, Security, Data JPA, AMQP)
- Spring Cloud (Gateway, Eureka)
- RabbitMQ
- MySQL
- Maven
- Docker & Docker Compose
- Swagger / Springdoc OpenAPI

## Architecture

Client -> API Gateway -> Microservices  
Microservices <-> Eureka Service Registry  
Vote Service -> RabbitMQ -> Election Service (async vote tally updates)

## Running Locally (Without Docker)

### Prerequisites

- Java 17+
- Maven
- MySQL (3 DBs: `voting_auth_db`, `election_db`, `vote_db`)
- RabbitMQ

### Steps

1. Configure environment variables in `.env` (use `.env.example` as reference).
2. Start `service-reg`.
3. Start `auth-service`, `election-service`, and `vote-service`.
4. Start `api-gateway`.

Gateway URL: `http://localhost:8080`

## Running with Docker Compose

From project root:

```bash
docker compose up --build
```

Useful URLs:

- API Gateway: `http://localhost:8080`
- Gateway Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Eureka Dashboard: `http://localhost:8761`
- RabbitMQ Management: `http://localhost:15672` (default `guest/guest`)

To stop:

```bash
docker compose down
```

To stop and remove volumes:

```bash
docker compose down -v
```

## API Documentation

Service-level docs:

- Auth: `http://localhost:8081/swagger-ui/index.html`
- Election: `http://localhost:8082/swagger-ui/index.html`
- Vote: `http://localhost:8083/swagger-ui/index.html`

Centralized docs (gateway):

- `http://localhost:8080/swagger-ui/index.html`

## Sample Flow

1. Register/Login via auth endpoints
2. Create election and candidates
3. Cast votes
4. Vote events are published to RabbitMQ
5. Election service consumes events and updates tally
6. Fetch tally from election service

## Environment & Security

- Secrets are externalized via environment variables
- `.env` is excluded from Git via `.gitignore`
- `.env.example` is provided for safe sharing

## Resume Value

This project showcases practical backend engineering skills:

- Microservices design
- API security with JWT
- Async messaging patterns
- API gateway and service discovery
- Containerized deployment
- Production-style configuration management

## Author

**Jayanth**  
If you found this project useful, feel free to star the repository.

