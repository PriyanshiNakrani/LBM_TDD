# Library Management System TDD Incubyte Kata Solution 📚

## Project Overview

The Library Management System is a Java-based application designed to manage books and users. This solution was developed using Test-Driven Development (TDD) practices to ensure robust validation and functionality of the core components: `Book` and `User`.

## Features

- **Book Management**:
  - Title, author, ISBN, and publication year validation
  - Title and author cannot start with numeric values
  - ISBN must be exactly 13 digits and numeric
  - Publication year must be a 4-digit numeric value

- **User Management**:
  - User name must be alphabetic and longer than 3 characters
  - User ID must be a positive integer

## Set Up Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 11 or higher installed.
- **Maven**: Make sure Maven is installed for building and managing dependencies.

### Tools

- **VS Code**: Open the project in VS Code.
- **Maven**: Open the `pom.xml` file when prompted and click "OK".

### Build Project

1. Open VS Code and navigate to the project directory.
2. Run the following Maven command to build the project:
   ```bash
   mvn clean install
