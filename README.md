# Library Management System TDD (Incubyte) Kata Solution 📚

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

## Development Approach and Code Quality

### Test-Driven Development (TDD)

In this project, we adhere to the Test-Driven Development (TDD) approach. TDD is a software development methodology where tests are written before the actual code. This approach helps in defining how the code should behave and ensures that it meets the specified requirements. The main steps in TDD include:

1. **Write a Test:** Begin by writing a test that defines a function or improvement you want to add.
2. **Run the Test:** Run the test to ensure that it fails (since the function or feature isn't implemented yet).
3. **Write Code:** Write the minimum code necessary to make the test pass.
4. **Run Tests:** Execute all tests to ensure that the new code does not break any existing functionality.
5. **Refactor Code:** Refactor the code to improve its structure and readability without changing its behavior.
6. **Repeat:** Repeat the process for each new feature or improvement.

By following TDD, we ensure that our code is thoroughly tested and that new changes do not introduce regressions.

### Code Refactoring

Code refactoring is a crucial part of our development process. We continuously refactor our code to improve its structure and readability while preserving its functionality. The goals of refactoring include:

- **Improving Code Readability:** Making the code easier to understand and maintain.
- **Enhancing Code Performance:** Optimizing code for better performance and efficiency.
- **Reducing Code Complexity:** Simplifying complex code structures to make them more manageable.
- **Eliminating Redundancies:** Removing duplicated code and consolidating similar functions.

We regularly review and refactor our code to ensure that it remains clean, efficient, and easy to work with.

# Test Coverage (94%)

Our project maintains a high level of test coverage, with an average coverage of 94%. Test coverage measures the percentage of code that is executed by our test cases. A high test coverage indicates that a significant portion of our code is tested, which helps in:

- **Ensuring Code Quality:** High test coverage helps identify issues early in the development process, reducing the likelihood of bugs.
- **Facilitating Refactoring:** Comprehensive tests make it safer to refactor code, knowing that any issues introduced by changes will be caught by the tests.
- **Boosting Developer Confidence:** With high test coverage, developers can confidently make changes and enhancements, knowing that existing functionality is well-tested.

By adhering to TDD, refactoring our code regularly, and maintaining high test coverage, we strive to deliver high-quality software that is robust, maintainable, and reliable.

# Git Commands for This Project

## Cloning the Repository

To clone the repository to your local machine, use:

```bash
git clone https://github.com/PriyanshiNakrani/LBM_TDD.git

## Conclusion

Our project is built with a strong focus on quality and maintainability through the adoption of Test-Driven Development (TDD) and rigorous code refactoring practices. By ensuring that tests are written before code and continuously refining our codebase, we strive to create software that is both reliable and efficient. 

With an impressive average test coverage of 94%, we are committed to maintaining high standards and identifying potential issues early in the development process. This approach not only enhances code quality but also boosts confidence in making changes and improvements.

We believe that these practices contribute significantly to the robustness and long-term success of our project, and we are dedicated to upholding these principles as we continue to develop and enhance our software.


