# Todo Management Application with Spring Data REST

## Project Overview

- This is a simple REST-Service with the help of Java, Spring Boot and Maven.
- The service allows managing Todos like you might know it from Todo list.
- Solution is a robust, scalable Todo management application built using Spring Boot and Spring Data REST, demonstrating modern RESTful API design principles.

## Project Requirements

### Core Functionality

- Create, Read, Update, and Delete (CRUD) Todo items
- Implement RESTful endpoints for Todo management
- Provide comprehensive error handling
- Support pagination and sorting
- Ensure clean, maintainable code structure

## Design Decisions: Why Spring Data REST?

### Architectural Choices

1. **Framework Selection: Spring Data REST**
    - Rapid API development
    - Automatic REST endpoint generation
    - Minimal boilerplate code
    - Built-in HATEOAS support
    - Easy integration with Spring ecosystem

### Libraries and Dependencies

#### Core Libraries

- **Spring Boot**: Application framework
- **Spring Data REST**: REST API generation
- **Spring Data JPA**: Database persistence
- **H2 Database**: In-memory development database
- **Lombok**: Reduces boilerplate code
- **Spring Boot Validation**: Input validation
- **Spring Boot Problem Details**: RFC 7807 error handling

#### Dependency Details

```xml

<dependencies>
   <!-- Spring Data REST -->
   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-rest</artifactId>
   </dependency>

   <!-- Spring Data JPA -->
   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>

   <!-- H2 Database -->
   <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
   </dependency>

   <!-- Lombok -->
   <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
   </dependency>

   <!-- Validation -->
   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-validation</artifactId>
   </dependency>
</dependencies>
```

## Advantages of Spring Data REST

### 1. HATEOAS / HAL Support

- Hypermedia-driven REST APIs
- Automatic link generation
- Self-documenting endpoints
- Improved API discoverability

### 2. HAL Browser

- Interactive API exploration
- Automatic endpoint documentation
- Easy navigation of API resources

### 3. Pagination Support

- Built-in pagination mechanisms
- Configurable page sizes
- Sorting capabilities
- Metadata for total pages and elements

### 4. Development Efficiency

- Automatic repository-based endpoints
- Reduced boilerplate code
- Minimal configuration required
- Quick prototyping and development

## Error Handling: RFC 7807 Problem Details

Spring Boot's Problem Detail specification provides standardized error responses:

### Error Response Structure

- `type`: URI identifying the problem type
- `title`: Short, human-readable error summary
- `status`: HTTP status code
- `detail`: Detailed error description
- `instance`: Specific occurrence identifier

### Example Error Response

```json
{
  "type": "/errors/validation-failed",
  "title": "Validation Error",
  "status": 400,
  "detail": "Todo title cannot be empty",
  "instance": "/todos"
}
```

## Getting Started

### Prerequisites

- Java 21
- Maven
- Docker

## Dockerization

### Docker Commands

```bash
# Build Docker image
docker build  -t todo-app-docker .

# Run application
docker run -p 8080:8080 todo-app-docker

```

## API Endpoints

- Please use postman collection (Todos.postman_collection.json) Or HAL explorer - http://localhost:8080/api Or 'curl' commands to test the APIs.

### 1. Get All Todos

```bash
curl -X GET http://localhost:8080/todos
```

### 2. Create a Todo

```bash
curl -X POST http://localhost:8080/api/todos -H "Content-Type: application/json" \
-d '{"name":"Project Tasks","description":"Main project tasks","tasks":[{"name":"Design","description":"Create initial design"}]}'
```

### 3. Get Specific Todo

```bash
curl -X GET http://localhost:8080/todos/1
```

### 4. Update Todo

```bash
curl -X PUT http://localhost:8080/api/todos/1 -H "Content-Type: application/json" \
-d '{"name":"Updated Project Tasks","description":"Updated description","tasks":[{"name":"Implement","description":"Start implementation"}]}'
```

### 5. Delete Todo

```bash
curl -X DELETE http://localhost:8080/todos/1
```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/maven-plugin)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.0/reference/using/devtools.html)
* [Rest Repositories](https://docs.spring.io/spring-boot/3.4.0/how-to/data-access.html#howto.data-access.exposing-spring-data-repositories-as-rest)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)