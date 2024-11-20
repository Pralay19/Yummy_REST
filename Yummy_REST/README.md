# Customer Management Application

This repository contains a Spring Boot application for managing customer data with login functionality, JWT-based authentication, and additional features. The project is organized in stages, guiding you through setting up, implementing core functionality, enhancing security, and practicing additional features.

## Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Stage 1: Initial Setup](#stage-1-initial-setup)
- [Stage 2: Implementing Login Functionality](#stage-2-implementing-login-functionality)
- [Stage 3: Enhancing Security with JWT](#stage-3-enhancing-security-with-jwt)

---

## Overview

The Customer Management Application is a Spring Boot project designed to manage customer data, with features such as user authentication, encrypted password storage, and JWT token-based security. The project follows a series of tasks, starting with the setup and progressing through functionality and security enhancements. This step-by-step approach aims to build a robust application while improving familiarity with Spring Boot, JWT, and RESTful API development.

## Project Structure

The project is divided into three main stages:
1. **Initial Setup** - Familiarize yourself with Spring Boot, annotations, and project structure.
2. **Implementing Login Functionality** - Build a basic login system for customer authentication.
3. **Enhancing Security with JWT** - Add JWT authentication and secure the application.

Additionally, a practice exercise is provided to reinforce the concepts of Spring Boot, JPA, and MySQL integration by adding CRUD operations on a `Product` entity.

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- MySQL Database
- Maven (for dependency management)

### Setting up the Project

1. Clone the repository.
2. Configure your database connection in `application.properties`.
3. Run the application using:
   ```bash
   mvn spring-boot:run

### Initial Setup
This stage provides a foundational understanding of Spring Boot syntax, annotations, and logic. The initial code snippet (Yummy_REST.zip) serves as a reference to learn how REST APIs and Spring Boot functionalities work.

Goal: Become familiar with the codebase and Spring Boot concepts in preparation for the upcoming tasks.

### Implementing Login Functionality
This stage focuses on building a basic login feature within the application.

Tasks
1.Create a Login API:
Add a new endpoint in CustomerController that accepts email and password as input.
If the credentials are correct, respond with the message: "User logged in successfully."

2.Create the Customer Entity:
Define a Customer entity with the following attributes: email, address, city, and pincode.
Map this entity to the database using JPA annotations.

3.Database Schema Changes:
Update the database schema to accommodate the new fields in the Customer entity.
Make sure the table in MySQL is updated with these new columns.

4.Implement a Search Method:
Create a method to find a customer by their email.
Commit Changes: Make individual commits for each functionality added (e.g., Create Customer, Login, etc.), with commit messages describing the changes.

### Enchancing security with JWT
This stage introduces JWT (JSON Web Token) authentication to enhance the application’s security.

Tasks
1.Password Encryption:
Encrypt passwords before saving them in the database.
Use a secure hashing algorithm, such as BCrypt, for password encryption.

2.Update Login Logic:
Modify the login logic to compare the entered password with the encrypted password stored in the database.

3.Generate JWT Token:
Implement logic to create a JWT token upon successful login.
Return the generated token to the user.

4.JWT Authentication:
Implement JWT token-based authentication for secured APIs, such as retrieving, updating, or deleting customer information.
Ensure that only authenticated users with valid JWT tokens can access these secured endpoints.

5.JWT Validation Function:
Create a common function to validate JWT tokens.
Use this function to verify user authorization for secure APIs.

Notes:
APIs such as customer creation and login are public and do not require JWT validation since users do not yet have tokens.
