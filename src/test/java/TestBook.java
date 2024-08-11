// package com.incubyte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.incubyte.Book;

/**
 * Unit tests for the Book class to ensure correct validation and functionality.
 */
public class TestBook {

    @Test
    public void testConstructorThrowsExceptionWhenTitleIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Book(null, "Joshua Bloch", "1234567890123", 2008),
                "Expected IllegalArgumentException when title is null.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenAuthorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", null, "1234567890123", 2008),
                "Expected IllegalArgumentException when author is null.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenTitleStartsWithNumeric() {
        assertThrows(IllegalArgumentException.class, () -> new Book("123Effective Java", "Joshua Bloch", "1234567890123", 2008),
                "Expected IllegalArgumentException when title starts with a numeric value.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenAuthorStartsWithNumeric() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "123Joshua Bloch", "1234567890123", 2008),
                "Expected IllegalArgumentException when author starts with a numeric value.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenTitleContainsOnlyNumeric() {
        assertThrows(IllegalArgumentException.class, () -> new Book("1234567890", "Joshua Bloch", "1234567890123", 2008),
                "Expected IllegalArgumentException when title contains only numeric values.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenAuthorContainsOnlyNumeric() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "1234567890", "1234567890123", 2008),
                "Expected IllegalArgumentException when author contains only numeric values.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenIsbnIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", null, 2008),
                "Expected IllegalArgumentException when ISBN is null.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenIsbnIsNot13Digits() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "123456789012", 2008),
                "Expected IllegalArgumentException when ISBN is less than 13 digits.");
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "12345678901234", 2008),
                "Expected IllegalArgumentException when ISBN is more than 13 digits.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenIsbnContainsNonNumericCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "1234567890ABC", 2008),
                "Expected IllegalArgumentException when ISBN contains non-numeric characters.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenPublicationYearIsNot4Digits() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "1234567890123", 200),
                "Expected IllegalArgumentException when publication year is less than 4 digits.");
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "1234567890123", 20088),
                "Expected IllegalArgumentException when publication year is more than 4 digits.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenPublicationYearContainsNonNumericCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "1234567890123", Integer.parseInt("20A8")),
                "Expected IllegalArgumentException when publication year contains non-numeric characters.");
    }

    @Test
    public void testConstructorCreatesBookSuccessfullyWithValidInputs() {
        Book book = new Book("Effective Java", "Joshua Bloch", "1234567890123", 2008);
        assertEquals("1234567890123", book.getIsbn(), "ISBN should be '1234567890123'.");
        assertEquals("Effective Java", book.getTitle(), "Title should be 'Effective Java'.");
        assertEquals("Joshua Bloch", book.getAuthor(), "Author should be 'Joshua Bloch'.");
        assertEquals(2008, book.getPublicationYear(), "Publication year should be 2008.");
    }
}
