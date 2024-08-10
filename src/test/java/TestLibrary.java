// package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.incubyte.Library;

public class TestLibrary {

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenLibNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Library(null));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenLibNameStartsWithNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new Library("1CentralLibrary"));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenLibNameContainsNumericValues() {
        assertThrows(IllegalArgumentException.class, () -> new Library("CentralLibrary1"));
    }

    @Test
    public void testThat_ConstructorMustThrowInvalidArgumentExceptionWhenLibNameIsLessThan3Characters() {
        assertThrows(IllegalArgumentException.class, () -> new Library("AB"));
    }
}
