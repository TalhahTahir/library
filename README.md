### Library Management System

This project is a comprehensive library management system that allows users to browse books, search for titles, and administrators to manage the book inventory through CRUD operations. Below you will find detailed documentation on how to set up, use, and contribute to this project.

## Table of Contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Set up the database](#set-up-the-database)
4. [Database Schema](#database-schema)
5. [Usage](#usage)
6. [Contributing](#contributing)
7. [Copyright](#copyright)


## Introduction

The Library Management System is a Spring Boot application designed to facilitate the management of books in a library. It includes functionalities for user browsing, book searching, and administrative tasks such as adding, updating, and deleting books.

## Prerequisites

- [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)
- [MySQL](https://www.mysql.com/products/community/)
- [Maven](https://maven.apache.org)
- [Spring Boot 3.4.4](https://spring.io/projects/spring-boot)


## Dependencies

The project relies on the following major dependencies:

- **Spring Boot Starter Data JPA**: For database access using Spring Data repositories
- **Spring Boot Starter Thymeleaf**: Template engine for server-side HTML rendering
- **Spring Boot Starter Validation**: For form validation
- **Spring Boot Starter Web**: For building web applications with Spring MVC
- **Spring Boot Starter Security**: For authentication and authorization
- **MySQL Connector**: Database driver for MySQL
- **Lombok**: For reducing boilerplate code
- **Springdoc OpenAPI**: For API documentation (Swagger UI available at `/swagger-ui.html`)


### Installation

1. Clone the repository:


```plaintext
git clone https://github.com/yourusername/library-management-system.git
```

2. Navigate to the project directory:


```plaintext
cd library-management-system
```

## Set up the database:

- Create a MySQL database named `library_db`
- Update the database connection details in `application.properties` file:


```plaintext
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Build the project using Maven:


```plaintext
mvn clean install
```

4. Run the application:


```plaintext
mvn spring-boot:run
```

or

```plaintext
java -jar target/library-0.0.1-SNAPSHOT.jar
```

## Database Schema

The database schema includes the following main table:

### books

| Column | Type | Description
|-----|-----|-----
| id | BIGINT | Primary key, auto-incremented
| title | VARCHAR(255) | Book title (not null)
| author | VARCHAR(255) | Book author (not null)
| year | VARCHAR(255) | Publication year
| catagory | VARCHAR(255) | Book category (not null)
| file | VARCHAR(255) | URL to the book file (not null)
| image | VARCHAR(9000) | URL to the book cover image
| description | VARCHAR(500) | Book description


The schema is automatically created by Hibernate when the application starts with `spring.jpa.hibernate.ddl-auto=update`.

## Usage

### User Interface

1. **Home Page**:

1. Access the system at `http://localhost:8080/`
2. Choose between User and Admin login



2. **User Panel** (accessible at `/home`):

1. Browse all available books
2. Search for books by title
3. View book details including cover image, author, category, and description
4. Access book files via provided links





### Admin Interface

1. **Admin Panel** (accessible at `/AdminPanel`):

1. Login with credentials:

1. Username: Talha
2. Password: 42155






2. **Book Management**:

1. View all books in the library
2. Add new books with details (title, author, year, category, image URL, file URL, description)
3. Update existing book information
4. Delete books from the library
5. Search for specific books by title



3. **Security**:

1. Admin panel is protected with authentication
2. CSRF protection is enabled for form submissions





## Technical Architecture

1. **Spring MVC Architecture**:

1. Controllers handle HTTP requests and responses
2. Services contain business logic
3. Repositories manage data access
4. Thymeleaf templates render the views



2. **Exception Handling**:

1. Global exception handler for consistent error responses
2. Custom exceptions for specific error scenarios
3. Validation error handling for form submissions



3. **Security**:

1. Spring Security for authentication and authorization
2. In-memory user details for admin access
3. Protected endpoints for administrative functions





## Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.


### Coding Standards

- Follow Java coding conventions
- Write unit tests for new features
- Update documentation as needed


## Copyright

© 2023 Talha Tahir. All rights reserved.

Released under the MIT License. See the [LICENSE](LICENSE) file.
