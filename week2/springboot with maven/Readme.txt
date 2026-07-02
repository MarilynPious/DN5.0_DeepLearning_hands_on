Library Management - Spring Core and Maven Hands-on

Project Description

This project demonstrates the basic concepts of Spring Boot, Spring Core, Dependency Injection, Maven, and the Spring IoC Container. The application follows a simple layered architecture consisting of Controller, Service, and Repository components.

Exercises Completed

Exercise 1 - Configuring a Basic Spring Application

- Created a Spring Boot project using Spring Initializr.
- Configured the project with Maven.
- Verified successful application startup.
- Embedded Tomcat server runs on port 8080.

Exercise 2 - Implementing Dependency Injection

- Implemented Dependency Injection using Spring.
- Created the following layers
  - BookController
  - BookService
  - BookRepository
- The Controller communicates with the Service, and the Service communicates with the Repository.

Exercise 4 - Creating and Configuring a Maven Project

- Managed project dependencies using pom.xml.
- Built the project successfully using Maven.
- Verified the build using
  - mvn clean
  - mvn package

Exercise 5 - Configuring the Spring IoC Container

- Demonstrated Spring Bean creation using
  - @RestController
  - @Service
  - @Repository
- Verified bean creation through console output during application startup.

Exercise 7 - Implementing Constructor and Setter Injection

Constructor Injection
- Implemented constructor injection in BookService and BookController.

Setter Injection
- Created NotificationService to demonstrate setter injection using @Autowired.

Exercise 9 - Creating a Spring Boot Application

- Developed a Spring Boot application using Spring Initializr.
- Configured the project using Maven.
- Successfully executed the application.
- Tested the REST endpoint.

Project Structure

LibraryManagement
│
├── controller
│     BookController.java
│
├── service
│     BookService.java
│     NotificationService.java
│
├── repository
│     BookRepository.java
│
├── LibraryManagementApplication.java
│
├── resources
│     application.properties
│
└── pom.xml

REST Endpoint

GET httplocalhost8080book

Expected Output

Harry Potter

Concepts Covered

- Spring Boot
- Spring Core
- Maven
- Dependency Injection
- Constructor Injection
- Setter Injection
- Spring IoC Container
- REST Controller
- Repository Layer
- Service Layer
- Layered Architecture

Build Commands

mvn clean

mvn package

Author

Marilyn Pious