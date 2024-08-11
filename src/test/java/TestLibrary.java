// package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.incubyte.Book;
import com.incubyte.Library;
import com.incubyte.User;

public class TestLibrary {

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenLibNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Library(null));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenLibNameStartsWithNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new Library("1PriyaLibrary"));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenLibNameContainsNumericValues() {
        assertThrows(IllegalArgumentException.class, () -> new Library("PriyaLibrary1"));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenLibNameIsLessThan3Characters() {
        assertThrows(IllegalArgumentException.class, () -> new Library("AB"));
    }

    @Test
    public void testThat_AddBookMustThrowIllegalArgumentExceptionWhenUserIsNull() {
        Library library = new Library("PriyaLibrary");
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        assertThrows(IllegalArgumentException.class, () -> library.addBook(null, book));
    }

    @Test
    public void testThat_AddBookMustThrowIllegalArgumentExceptionWhenBookIsNull() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);

        assertThrows(IllegalArgumentException.class, () -> library.addBook(user, null));
    }

    @Test
    public void testThat_AddBookMustThrowIllegalArgumentExceptionWhenBothParametersAreNull() {
        Library library = new Library("PriyaLibrary");

        assertThrows(IllegalArgumentException.class, () -> library.addBook(null, null));
    }

    @Test
    public void testAddBookUniqueAndHandleDuplicates() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        library.addBook(user, book);
        assertEquals(1, library.getBooks().size());
        assertTrue(library.getBooks().containsKey(book.getIsbn()));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(user, book);
        });
        assertEquals("Book with this ISBN already exists.", thrown.getMessage());

        assertEquals(2, library.getBookDB().get(book));
    }

    @Test
    public void testAddNullBook() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Alice", 1);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(user, null);
        });

        assertEquals("Book cannot be null.", thrown.getMessage());
    }

    @Test
    public void testAddNullUser() {
        Library library = new Library("PriyaLibrary");
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(null, book);
        });

        assertEquals("User cannot be null.", thrown.getMessage());
    }

    @Test
    public void testShowBooksWhenNoBooksAdded() {
        Library library = new Library("PriyaLibrary");
        List<Book> books = library.showBooks();
        assertTrue(books.isEmpty(), "Expected empty list when no books are added.");
    }

    @Test
    public void testShowBooksWithSingleBook() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);
        library.addBook(user, book);
        List<Book> books = library.showBooks();
        assertEquals(1, books.size(), "Expected list to contain one book.");
        assertTrue(books.contains(book), "The list should contain the added book.");
    }

    @Test
    public void testShowBooksWithMultipleUniqueBooks() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book1 = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);
        Book book2 = new Book("Clean Code", "Robert Martin", "9780132350884", 2003);
        library.addBook(user, book1);
        library.addBook(user, book2);
        List<Book> books = library.showBooks();
        assertEquals(2, books.size(), "Expected list to contain two unique books.");
        assertTrue(books.contains(book1) && books.contains(book2), "The list should contain both added books.");
    }

    @Test
    public void testShowBooksWithDuplicateBooks() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);
        library.addBook(user, book);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(user, book);
        });
        assertEquals("Book with this ISBN already exists.", thrown.getMessage());

        Book anotherBook = new Book("Clean Code", "Robert Martin", "9780132350884", 2003);
        library.addBook(user, anotherBook);

        List<Book> books = library.showBooks();
        assertEquals(2, books.size(), "Expected list to contain two unique books.");
        assertTrue(books.contains(book), "The list should contain the first added book.");
        assertTrue(books.contains(anotherBook), "The list should contain the second added book.");
    }

    @Test
    public void testBorrowBookWhenBookIsNotPresent() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        assertThrows(IllegalArgumentException.class, () -> library.borrowBook(book, user),
                "Expected IllegalArgumentException when attempting to borrow a book that is not present.");
    }

    @Test
    public void testBorrowBookWhenUserIsNotRegistered() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Deva", 2);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        library.addBook(user, book);

        library.registerUser(user);

        library.borrowBook(book, user);

    }

    @Test
    public void testBorrowBookWhenUserExceedsBorrowLimit() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book1 = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);
        Book book2 = new Book("Clean Code", "Robert Martin", "9780132350884", 2003);
        Book book3 = new Book("Design Patterns", "Gang of Four", "9780201633610", 1994);

        library.registerUser(user);
        library.addBook(user, book1);
        library.addBook(user, book2);
        library.addBook(user, book3);

        library.borrowBook(book1, user);
        library.borrowBook(book2, user);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook(book3, user),
                "Expected IllegalArgumentException when attempting to borrow more than 2 books.");

        assertEquals("User can only borrow up to 2 books.", thrown.getMessage());
    }

    @Test
    public void testBorrowBookWhenBookIsAlreadyBorrowed() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        library.registerUser(user);
        library.addBook(user, book);

        library.borrowBook(book, user);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook(book, user),
                "Expected IllegalArgumentException when attempting to borrow a book that is already borrowed by the user.");

        assertEquals("Book is already borrowed by the user.", thrown.getMessage());
    }

    @Test
    public void testReturnBookSuccessfully() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        library.registerUser(user);
        library.addBook(user, book);
        library.borrowBook(book, user);

        library.returnBook(book, user);

        assertEquals(1, library.getBookDB().get(book));
        assertFalse(library.getUserBooks(user).contains(book),
                "User's borrowed books should not contain the returned book.");
    }

    @Test
    public void testReturnBookNotBorrowedByUser() {
        Library library = new Library("PriyaLibrary");
        User user1 = new User("Priya", 1);
        User user2 = new User("Alice", 2);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        library.registerUser(user1);
        library.registerUser(user2);
        library.addBook(user1, book);
        library.borrowBook(book, user1);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook(book, user2);
        });
        assertEquals("Book was not borrowed by this user.", thrown.getMessage());
    }

    @Test
    public void testReturnBookThatWasNotBorrowed() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        library.registerUser(user);
        library.addBook(user, book);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook(book, user);
        });
        assertEquals("Book was not borrowed.", thrown.getMessage());
    }

    @Test
    public void testReturnBookWhenNoCopiesAvailable() {
        Library library = new Library("PriyaLibrary");
        User user = new User("Priya", 1);
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018);

        library.registerUser(user);
        library.addBook(user, book);
        library.borrowBook(book, user);

        library.getBookDB().put(book, 0);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook(book, user);
        });
        assertEquals("Cannot return a book with no copies available.", thrown.getMessage());
    }

}
