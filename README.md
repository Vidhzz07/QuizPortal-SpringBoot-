# Quiz portal  API

 This application provides a RESTful API that allows users to sign in, sign out, add and attempt questions based on various category. It uses JWT authentication and Spring Security for securing endpoints, MySQL for persisting user data and questions data, and SLF4J for logging. The project also includes JUnit tests for service layers and a global exception handler for managing errors.

## Features

- **User Authentication**: Secure sign-in and sign-out using JWT tokens.
- **Code Storage**: Save and retrieve questions and answers.
- **Caching**: Improve performance with Redis caching.
- **Global Exception Handling**: Handle exceptions globally with a custom exception handler.
- **Logging**: Use SLF4J for logging application events and errors.
- **Testing**: JUnit for unit testing service layers.

## Technologies Used

- **Java**: The programming language used to build the application.
- **Spring Boot**: Framework for building the application.
- **Spring Security**: For securing the REST API with JWT authentication.
- **MySQL**: SQL database for storing data.
- **Spring Data JPA**: For database operations.
- **Redis**: Caching layer for performance enhancement.
- **Spring Data Redis**: For Redis operations.
- **SLF4J**: For logging.
- **JUnit**: For unit testing service layers.
