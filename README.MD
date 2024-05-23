# Library Management System

This is a RESTful API for managing a simple library system. The API allows users to register borrowers and books, view all books in the library, and manage book borrowing and returning.

## Features

1. Register a new borrower.
2. Register a new book.
3. Get a list of all books.
4. Borrow a book.
5. Return a borrowed book.

## Prerequisites

- Java 17
- Maven
- PostgreSQL

## Setup

### Database Configuration

1. Install PostgreSQL and create a new database (e.g., `library-api`).
2. Update `src/main/resources/application.yml` with your PostgreSQL credentials:

   ```properties
   spring:
    datasource:
    url: jdbc:postgresql://localhost:5433/library-api
    username: postgres
    password: 1234
   
3. **Build Project**: Run `mvn clean install` to build the project.
4. **Run Application**: Execute the generated JAR file to start the Spring Boot application.

## Running the Postman Collection

To run the provided Postman collection, follow these steps:

1. **Import Postman Collection**:
- [Download the Postman Collection JSON file](src/main/resources/static/library-api.postman_collection.json).
- Open Postman and import the collection using the "Import" feature.

2. **Import Environment**:
- [Download the Postman Environment JSON file](src/main/resources/static/library-api-local.postman_environment.json).
- Open Postman and import the environment using the "Import" feature.

3. **Run Collection**:
- Once the collection and environment are imported, select the desired environment from the dropdown menu.
- Select the imported collection from the left sidebar and click on the "Run" button to execute the requests.


