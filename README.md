# 📦 Smart Restaurant Order Manager (SROM)

## Overview
The Smart Restaurant Order Manager (SROM) is a comprehensive academic project that applies advanced software engineering concepts including:
- Domain-Driven Design (DDD)
- Test-Driven Development (TDD)
- Continuous Integration (CI/CD)
- Code Quality Analysis (SonarQube, PIT, JaCoCo)
- Docker-based deployment
- Multi-level testing (Unit, Integration, End-to-End)

## Modules Structure
- `lrom-domain`: Core domain models (Order, Reservation, Table, MenuItem, Invoice).
- `lrom-repository`: In-memory repositories implementing the data layer.
- `lrom-services`: Business logic and service layer.
- `lrom-tests`: Unit tests written in JUnit 5.
- `lrom-integration-tests`: Integration tests using TestContainers.
- `lrom-e2e-tests`: Full E2E testing using Cucumber & Gherkin.
- `lrom-quality`: Code coverage & mutation testing (JaCoCo, PIT).
- `lrom-ci`: GitHub Actions CI workflows.
- `lrom-docker`: Docker build & deployment files.

## Technologies Used
- Java 17 (Language)
- Maven (Build Automation)
- JUnit 5 (Unit Testing)
- Mockito (Mock Testing)
- TestContainers (Integration Testing)
- Cucumber (E2E Testing)
- PIT (Mutation Testing)
- JaCoCo (Code Coverage)
- SonarQube (Code Quality Analysis)
- Docker (Containerization)
- GitHub Actions (CI/CD Pipelines)

## Build Instructions
```bash
mvn clean verify
```

## Docker Deployment
```bash
docker-compose up --build
```

## CI/CD Pipelines
- Configured under `lrom-ci/.github/workflows/` for full automation of build, test, and quality analysis.

## Contact & Supervisor
- Author: Alhussein Ghader
- Supervisor: [To be filled]