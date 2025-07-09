---

# Cloud Vendor API

A secure, modular, and production-grade RESTful API developed using Spring Boot, aimed at efficiently managing cloud vendor data. The application supports full CRUD operations, integrates authentication and role-based authorization via Spring Security, provides interactive API documentation using Swagger, and follows clean code practices with a layered architecture for scalability and maintainability.

---

## Project Overview

This API allows clients to create, read, update, and delete cloud vendor information. It is designed following enterprise backend development standards and includes:

* DTO-based data transfer
* Layered architectural separation
* Role-based authorization (ADMIN, USER)
* Global exception handling
* Swagger documentation via Springdoc

---

## Features

* CRUD operations on cloud vendor data
* Authentication and role-based authorization using Spring Security
* BCrypt password hashing
* Swagger UI for interactive API exploration
* Centralized exception handling
* Tested with JUnit, Mockito, and Postman

---

## Tech Stack

| Layer                 | Technology                     |
| --------------------- | ------------------------------ |
| Language              | Java 21                        |
| Framework             | Spring Boot 3.5.3              |
| ORM                   | Spring Data JPA                |
| Database              | MySQL (Runtime), H2 (Test)     |
| Security              | Spring Security                |
| Documentation         | Springdoc OpenAPI + Swagger UI |
| Boilerplate Reduction | Lombok                         |
| Build Tool            | Maven                          |
| Testing               | JUnit, Mockito, Postman        |

---

## Dependencies Used

| Dependency           | Artifact                                                  | Purpose                                              |
| -------------------- | --------------------------------------------------------- | ---------------------------------------------------- |
| Spring Web           | `spring-boot-starter-web`                                 | To build RESTful APIs using Spring MVC               |
| Spring Data JPA      | `spring-boot-starter-data-jpa`                            | ORM and database interaction                         |
| MySQL Connector      | `mysql-connector-j`                                       | JDBC driver to connect to MySQL                      |
| Spring Security      | `spring-boot-starter-security`                            | Authentication and role-based authorization          |
| Lombok               | `lombok`                                                  | Eliminates boilerplate code (getters, setters, etc.) |
| Springdoc OpenAPI UI | `springdoc-openapi-starter-webmvc-ui`                     | Auto-generates Swagger-based API documentation       |
| Spring Boot Test     | `spring-boot-starter-test`                                | Base testing framework (JUnit, assertions)           |
| Spring Security Test | `spring-security-test`                                    | Enables testing of Spring Security contexts          |
| H2 Database          | `h2`                                                      | In-memory database used during testing               |
| Mockito Core         | `mockito-core` (inherited via `spring-boot-starter-test`) | Mocking objects in unit tests                        |

---

## Getting Started

### Prerequisites

* Java 17 or higher
* Maven
* MySQL

### Configuration

Update your `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/cloud_vendor?useSSL=false&allowPublicKeyRetrieval=true
    username: root
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

server:
  port: 8080
```

---

### Build & Run

```bash
git clone https://github.com/lakshitaaaaaa/cloud-vendor-api-development.git
cd cloud-vendor-api-development
mvn clean install
mvn spring-boot:run
```

---

## Authentication & Authorization

* **Authentication**: Basic authentication using Spring Security and BCrypt password encryption.
* **Authorization**: Role-based access control with `ADMIN` and `USER` roles.
* **Testing**: Postman used to verify role-specific access and authentication.

---

## API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```
http://localhost:8080/v3/api-docs
```

---

## Project Structure and Layers

### Main Structure (`src/main/java/com/develop/rest_api`)

| Path                      | Layer            | Description                                                 |
| ------------------------- | ---------------- | ----------------------------------------------------------- |
| `config/`                 | Security Layer   | Configures Spring Security with roles and password encoding |
| `controller/`             | Controller Layer | Handles API requests and maps them to service logic         |
| `dto/`                    | DTO Layer        | Secure data transfer between client and server              |
| `exception/`              | Exception Layer  | Global and custom exception handling                        |
| `mapper/`                 | Mapping Layer    | Converts between entities and DTOs or `UserDetails`         |
| `model/`                  | Entity Layer     | JPA entity classes for User and CloudVendor                 |
| `repository/`             | Repository Layer | Interfaces for DB operations using Spring Data JPA          |
| `response/`               | Utility Layer    | Generates consistent HTTP responses                         |
| `serviceLayer/`           | Service Layer    | Interfaces and business logic implementations               |
| `RestApiApplication.java` | Entry Point      | Main Spring Boot application class                          |

---

### Test Structure (`src/test/java/com/develop/rest_api`)

| File                                   | Type             | Description                                |
| -------------------------------------- | ---------------- | ------------------------------------------ |
| `CloudVendorControllerTest.java`       | Unit Test        | Tests controller endpoints using `MockMvc` |
| `CloudVendorRepositoryTest.java`       | Repository Test  | Validates database query logic             |
| `CloudVendorServiceImplementTest.java` | Unit Test        | Business logic test using Mockito          |
| `RestApiApplicationTests.java`         | Integration Test | Verifies Spring context loading            |
| `application.yaml`                     | Config           | Sets test DB and properties (uses H2)      |

---

## Architecture

```
Client → Controller → Service → Repository → Database
                      ↑
           DTO ↔ Mapper ↔ Model
                      ↓
                Exception, Security, Response
```

* **Controller**: API endpoints
* **Service**: Business logic
* **Repository**: Database access
* **Model/DTO**: Data structure
* **Mapper**: Transforms between DTOs and models
* **Security**: Handles auth and roles
* **Exception**: Centralized error management
* **ResponseHandler**: Uniform response structure

---

## Testing

*  **Postman**: Manual endpoint testing with role-based credentials
*  **JUnit + Mockito**: For services, controllers, and repositories
*  **Spring Boot Test**: Integration tests using H2

Run:

```bash
mvn test
```

---

## Future Improvements

* Switch from Basic Auth to JWT-based security
* Add advanced validation using `@Valid` and `@Validated`
* Dockerize the project using Dockerfile and `docker-compose`
* Implement CI/CD with GitHub Actions
* Add global logging and audit trail
* Rate limiting and request throttling
* Improve Swagger docs with DTO schema examples
* Integrate Redis caching for vendor listings

---

## License

This project is for academic and educational use.

---
