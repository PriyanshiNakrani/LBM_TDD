# Library Management System

## Overview

This Library Management System allows users to perform basic operations related to managing a library's book collection. Users can add new books, borrow books, return books, and view available books. The system is designed to handle simple library operations and ensure that books are managed efficiently.

## Features

- **Add Books**: Users can add new books to the library with details like title, author, ISBN, and publication year.
- **Borrow Books**: Users can borrow books from the library, ensuring that the book is available and the user adheres to borrowing limits.
- **Return Books**: Users can return borrowed books, updating the availability of the book in the library.
- **View Available Books**: Users can view a list of all books currently available in the library.

## Requirements

- Java 17 or higher

## Getting Started

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/library-management-system.git
    ```
2. Navigate to the project directory:
    ```sh
    cd library-management-system
    ```
3. Compile the project using your preferred Java build tool (e.g., Maven, Gradle) or using `javac`:
    ```sh
    javac -d bin src/com/incubyte/*.java
    ```

### Running the Application

1. Navigate to the `bin` directory:
    ```sh
    cd bin
    ```
2. Run the `Library` class to start the application:
    ```sh
    java com.incubyte.Library
    ```

### Running Tests

1. Navigate to the test directory:
    ```sh
    cd src/test
    ```
2. Compile the test classes:
    ```sh
    javac -d ../bin -cp .:../lib/junit-5.8.1.jar *.java
    ```
3. Run the tests using the JUnit platform:
    ```sh
    java -jar ../lib/junit-platform-console-standalone-1.8.1.jar -cp ../bin --scan-classpath
    ```

## Usage

### Adding a Book

```java
Library library = new Library("City Library");
User user = new User("Alice", 1);
Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925);
library.addBook(user, book);
