# Spring Boot JDBC REST API

## Overview
A backend REST API developed using Java and Spring Boot to perform CRUD (Create, Read, Update, Delete) operations on Alien records stored in a relational database. The application uses Spring MVC to handle HTTP requests and Spring JDBC (`JdbcTemplate`) to interact with the database.

## Technologies Used
- Java
- Spring Boot
- Spring MVC
- Spring JDBC (`JdbcTemplate`)
- MySQL
- Maven
- Postman

## Features
- Retrieve all Alien records.
- Retrieve an individual record using its ID.
- Create new Alien records.
- Update existing Alien records.
- Delete records by ID.
- Test and verify API endpoints using Postman.

## API Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/aliens` | Retrieve all records |
| GET | `/aliens/{id}` | Retrieve a record by ID |
| POST | `/postalien` | Create a record |
| PUT | `/upalien` | Update a record's technology |
| DELETE | `/dalien/{id}` | Delete a record by ID |

## Project Structure

```text
src/main/java/com/example/springWebJDBC/
├── controller/
│   └── AlienController.java
├── model/
│   └── Alien.java
├── service/
│   └── AlienService.java
└── SpringWebJdbcApplication.java
```

## Setup and Execution

1. Clone this repository.
2. Ensure Java, Maven, and MySQL are installed.
3. Create a MySQL database and an `Alien` table with `id`, `name`, and `tech` columns.
4. Configure your database URL, username, and password in `application.properties`.
5. Run the application using your IDE or execute:

   ```bash
   mvn spring-boot:run
   ```

6. Test the endpoints using Postman.

## Testing
Used Postman to send HTTP requests and verify the functionality of GET, POST, PUT, and DELETE endpoints.

## Learning Outcomes
- Understanding Spring Boot application structure.
- Implementing RESTful endpoints using Spring MVC.
- Using constructor-based dependency injection.
- Performing database operations with Spring JDBC and `JdbcTemplate`.
- Testing backend APIs using Postman.
