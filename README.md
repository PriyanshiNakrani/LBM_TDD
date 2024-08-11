# Library Management System TDD Incubyte Kata Solution 📚

## Project Overview

The Library Management System is a Java-based application designed to handle the management of books and users within a library. This project is built using Test-Driven Development (TDD) principles to ensure high-quality code through rigorous testing. The system includes functionalities for managing books and users, with detailed validation rules to maintain data integrity.

## Features

### Book Management

- **Book Validation**:
  - **Title**: Must be a non-empty string and cannot start with a numeric value or contain only numeric values.
  - **Author**: Must be a non-empty string and cannot start with a numeric value or contain only numeric values.
  - **ISBN**: Must be exactly 13 digits long and numeric.
  - **Publication Year**: Must be a 4-digit numeric value.

### User Management

- **User Validation**:
  - **User Name**: Must be longer than 3 characters, start with an alphabetic character, and contain only alphabetic characters.
  - **User ID**: Must be a positive integer.

### Library Management

- **Library Operations**:
  - **Add Book**: Add a new book to the library's collection.
  - **Return Book**: Return a book from the library's collection.
  - **Borrow Book**: Borrow details of a book by its ISBN.
  - **Show Books**: List all books currently in the library.

## Setup Instructions

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure that JDK 11 or higher is installed on your machine.
2. **Maven**: Install Maven for dependency management and build automation.

### Tools

1. **VS Code**:
   - Open Visual Studio Code.
   - Navigate to the project directory and open the `pom.xml` file when prompted. Click "OK" to import the Maven project.

### Building the Project

1. **Navigate to the Project Directory**:
    ```bash
    cd path/to/your/project
    ```
2. **Build the Project**:
    ```bash
    mvn clean install
    ```

### Running Tests

1. **Execute Unit Tests**:
    ```bash
    mvn test
    ```

## Code Structure

### Book Class 📖

- **Description**: Represents a book with attributes and validations.
- **Key Methods**:
  - `validateNonNullAndNotEmpty(String value, String fieldName)`: Ensures title and author are non-null and non-empty.
  - `validateTitleAndAuthor(String title, String author)`: Checks that the title and author do not start with a numeric value and are not numeric only.
  - `validateIsbn(String isbn)`: Validates the ISBN to be exactly 13 digits long and numeric.
  - `validatePublicationYear(int publicationYear)`: Ensures the publication year is a 4-digit numeric value.
- **Unit Tests**:
  - Test Constructor Throws Exception When Title Is Null
  - Test Constructor Creates Book Successfully With Valid Inputs

### User Class 🧑‍💼

- **Description**: Represents a user with attributes and validations.
- **Key Methods**:
  - `validateUserName(String userName)`: Ensures the user name is non-null, longer than 3 characters, starts with a letter, and contains only alphabetic characters.
  - `validateUserId(int userId)`: Ensures the user ID is a positive integer.
- **Unit Tests**:
  - Test Constructor Throws Exception When UserName Is Null
  - Test Constructor Creates User Successfully With Valid Inputs

### Library Class 📚

- **Description**: Manages the collection of books and users.
- **Key Methods**:
  - `addBook(Book book)`: Adds a Book instance to the library.
  - `returnBook(String isbn)`: Returns a Book instance to the library by its ISBN.
  - `borrowBook(String isbn)`: Finds and retrieves a Book instance by its ISBN.
  - `showBooks()`: Lists all Book instances currently in the library.
- **Unit Tests**:
  - Test Add Book
  - Test Borrow Book
