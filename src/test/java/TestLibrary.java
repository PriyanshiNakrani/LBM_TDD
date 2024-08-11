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

}
