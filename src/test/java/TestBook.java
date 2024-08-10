// package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.incubyte.Book;

public class TestBook {

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenCalledWithNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Book(null, "Joshua Bloch", "1234567890", 2008));
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", null, "1234567890", 2008));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenTitleStartsWithNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new Book("123Effective Java", "Joshua Bloch", "1234567890", 2008));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenAuthorStartsWithNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "123Joshua Bloch", "1234567890", 2008));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenTitleContainsOnlyNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new Book("1234567890", "Joshua Bloch", "1234567890", 2008));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenAuthorContainsOnlyNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "1234567890", "1234567890", 2008));
    }
    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenIsbnIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", null, 2008));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenIsbnIsNot13Digits() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "123456789012", 2008));
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "12345678901234", 2008));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenIsbnContainsNonNumericCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "1234567890ABC", 2008));
    }
    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenPublicationYearIsNot4Digits() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "1234567890123", 200));
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "1234567890123", 20088));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenPublicationYearContainsNonNumericCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Effective Java", "Joshua Bloch", "1234567890123", Integer.parseInt("20A8")));
    }
}
