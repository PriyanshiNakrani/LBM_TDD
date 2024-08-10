// package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
