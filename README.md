# Laboratory

Demo project for Spring Boot - A laboratory management system with REST APIs for managing affiliates, appointments, and tests.

## 📋 Overview

This is a Spring Boot application that provides a RESTful API for a laboratory management system. It includes entities for managing:
- **Affiliates** - Patient/client information
- **Appointments** - Scheduling and managing appointments
- **Tests** - Laboratory tests and their results

## 🛠 Tech Stack

- **Java**: 17
- **Framework**: Spring Boot 3.0.1-SNAPSHOT
- **Database**: MySQL (with `mysql-connector-j`)
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Maven (with wrapper)
- **Additional**: Lombok, Spring Boot DevTools

## 📦 Dependencies

| Dependency | Purpose |
|------------|---------|
| `spring-boot-starter-data-jpa` | JPA/Hibernate for database access |
| `spring-boot-starter-web` | REST API and web layer |
| `spring-boot-devtools` | Development tools (hot reload) |
| `mysql-connector-j` | MySQL database driver |
| `lombok` | Reduce boilerplate code |
| `spring-boot-starter-test` | Testing utilities |

## 🏗 Project Structure

```
src/main/java/com/laboratory/demo/
├── LaboratoryApplication.java          # Main entry point
├── controllers/                        # REST Controllers
│   ├── AffiliatesControllers.java
│   ├── AppoinmentsControllers.java
│   └── TestsControllers.java
├── entity/                             # JPA Entities
│   ├── Affiliates.java
│   ├── Appoinments.java
│   └── Tests.java
├── entity/dto/                         # Data Transfer Objects
│   ├── AffiliatesDto.java
│   ├── AppoinmentsDto.java
│   └── TestsDto.java
├── repository/                         # Spring Data Repositories
│   ├── AffiliatesRepository.java
│   ├── AppoinmentsRepository.java
│   └── TestsRepository.java
└── service/                            # Business Logic
    ├── AffiliatesService.java
    ├── AppoinmentsService.java
    └── TestsService.java
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use the included wrapper `./mvnw`)
- MySQL database running

### Configuration

Configure your database connection in `src/main/resources/application.properties` (or `application.yml`):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/laboratory_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Running the Application

Using Maven Wrapper (recommended):
```bash
./mvnw spring-boot:run
```

Or with Maven directly:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Building

```bash
./mvnw clean package
```

The JAR will be available in `target/Laboratory-0.0.1-SNAPSHOT.jar`

## 📚 API Endpoints

### Affiliates
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/affiliates` | List all affiliates |
| GET | `/api/affiliates/{id}` | Get affiliate by ID |
| POST | `/api/affiliates` | Create new affiliate |
| PUT | `/api/affiliates/{id}` | Update affiliate |
| DELETE | `/api/affiliates/{id}` | Delete affiliate |

### Appointments
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/appointments` | List all appointments |
| GET | `/api/appointments/{id}` | Get appointment by ID |
| POST | `/api/appointments` | Create new appointment |
| PUT | `/api/appointments/{id}` | Update appointment |
| DELETE | `/api/appointments/{id}` | Delete appointment |

### Tests
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/tests` | List all tests |
| GET | `/api/tests/{id}` | Get test by ID |
| POST | `/api/tests` | Create new test |
| PUT | `/api/tests/{id}` | Update test |
| DELETE | `/api/tests/{id}` | Delete test |

## 🧪 Running Tests

```bash
./mvnw test
```

Test classes are located in:
- `src/test/java/com/laboratory/demo/LaboratoryApplicationTests.java`
- `src/test/java/com/laboratory/demo/testControllers/`

## 📝 License

This project is a demo/educational project for Spring Boot.

---

**Generated with Spring Boot 3.0.1-SNAPSHOT**