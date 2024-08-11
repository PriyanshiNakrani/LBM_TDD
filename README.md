<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
</head>
<body>
    <h1>Library Management System</h1>

    <h2>Overview</h2>
    <p>This Library Management System allows users to perform basic operations related to managing a library's book collection. Users can add new books, borrow books, return books, and view available books. The system is designed to handle simple library operations and ensure that books are managed efficiently.</p>

    <h2>Features</h2>
    <ul>
        <li><strong>Add Books</strong>: Users can add new books to the library with details like title, author, ISBN, and publication year.</li>
        <li><strong>Borrow Books</strong>: Users can borrow books from the library, ensuring that the book is available and the user adheres to borrowing limits.</li>
        <li><strong>Return Books</strong>: Users can return borrowed books, updating the availability of the book in the library.</li>
        <li><strong>View Available Books</strong>: Users can view a list of all books currently available in the library.</li>
    </ul>

    <h2>Requirements</h2>
    <p>- Java 17 or higher</p>

    <h2>Getting Started</h2>

    <h3>Installation</h3>
    <ol>
        <li>Clone the repository:
            <pre><code>git clone https://github.com/your-username/library-management-system.git</code></pre>
        </li>
        <li>Navigate to the project directory:
            <pre><code>cd library-management-system</code></pre>
        </li>
        <li>Compile the project using your preferred Java build tool (e.g., Maven, Gradle) or using <code>javac</code>:
            <pre><code>javac -d bin src/com/incubyte/*.java</code></pre>
        </li>
    </ol>

    <h3>Running the Application</h3>
    <ol>
        <li>Navigate to the <code>bin</code> directory:
            <pre><code>cd bin</code></pre>
        </li>
        <li>Run the <code>Library</code> class to start the application:
            <pre><code>java com.incubyte.Library</code></pre>
        </li>
    </ol>

    <h3>Running Tests</h3>
    <ol>
        <li>Navigate to the test directory:
            <pre><code>cd src/test</code></pre>
        </li>
        <li>Compile the test classes:
            <pre><code>javac -d ../bin -cp .:../lib/junit-5.8.1.jar *.java</code></pre>
        </li>
        <li>Run the tests using the JUnit platform:
            <pre><code>java -jar ../lib/junit-platform-console-standalone-1.8.1.jar -cp ../bin --scan-classpath</code></pre>
        </li>
    </ol>

    <h2>Usage</h2>

    <h3>Adding a Book</h3>
    <pre><code>
Library library = new Library("City Library");
User user = new User("Alice", 1);
Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925);
library.addBook(user, book);
    </code></pre>

    <h3>Borrowing a Book</h3>
    <pre><code>
library.registerUser(user);
library.borrowBook(book, user);
    </code></pre>

    <h3>Returning a Book</h3>
    <pre><code>
library.returnBook(book, user);
    </code></pre>

    <h3>Viewing Available Books</h3>
    <pre><code>
List<Book> books = library.showBooks();
books.forEach(b -> System.out.println(b.getTitle()));
    </code></pre>

    <h2>Contributing</h2>
    <ol>
        <li>Fork the repository.</li>
        <li>Create a new branch (<code>git checkout -b feature-branch</code>).</li>
        <li>Make your changes.</li>
        <li>Commit your changes (<code>git commit -am 'Add new feature'</code>).</li>
        <li>Push to the branch (<code>git push origin feature-branch</code>).</li>
        <li>Create a new Pull Request.</li>
    </ol>

    <h2>License</h2>
    <p>This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>

    <h2>Acknowledgments</h2>
    <ul>
        <li>Inspiration: Various library management systems</li>
        <li>Libraries: JUnit for testing</li>
    </ul>
</body>
</html>
