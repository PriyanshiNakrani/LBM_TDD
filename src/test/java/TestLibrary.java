// package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(1, library.getDuplicateBookCounter()); 

        assertEquals(1, library.getBooks().size());
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
        library.addBook(user, book);
        List<Book> books = library.showBooks();
        assertEquals(1, books.size(), "Expected list to contain one unique book");
        assertTrue(books.contains(book), "The list should contain the unique book");
    }

}
