// package com.incubyte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.incubyte.User;

/**
 * Tests for the User class to ensure correct behavior of user creation and validation.
 */
public class TestUser {

    @Test
    public void testConstructorThrowsExceptionWhenUserNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, 12345),
                "Expected IllegalArgumentException when userName is null.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenUserNameContainsNonAlphabeticCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new User("Priya123", 12345),
                "Expected IllegalArgumentException when userName contains non-alphabetic characters.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenUserNameIsShort() {
        assertThrows(IllegalArgumentException.class, () -> new User("Pri", 12345),
                "Expected IllegalArgumentException when userName is less than 4 characters.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenUserNameStartsWithNumericValue() {
        assertThrows(IllegalArgumentException.class, () -> new User("1Priya", 12345),
                "Expected IllegalArgumentException when userName starts with a numeric value.");
    }

    @Test
    public void testConstructorThrowsExceptionWhenUserIdIsNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> new User("Priya", -1),
                "Expected IllegalArgumentException when userId is non-positive.");
    }

    @Test
    public void testConstructorCreatesUserSuccessfullyWithValidInputs() {
        User user = new User("Priya", 12345);
        assertEquals("Priya", user.getUserName(), "UserName should be 'Priya'.");
        assertEquals(12345, user.getUserId(), "UserId should be 12345.");
    }
}
