package com.incubyte;

/**
 * Represents a User with a name and ID.
 */
public class User {
    private final String userName;
    private final int userId;

    /**
     * Creates a new User with the specified name and ID.
     *
     * @param userName the name of the user
     * @param userId   the ID of the user
     */
    public User(String userName, int userId) {
        validateUserName(userName);
        validateUserId(userId);
        this.userName = userName;
        this.userId = userId;
    }

    private void validateUserName(String userName) {
        if (userName == null) {
            throw new IllegalArgumentException("UserName cannot be null.");
        }
        if (userName.length() <= 3) {
            throw new IllegalArgumentException("UserName must be longer than 3 characters.");
        }
        if (!userName.matches("^[a-zA-Z].*")) {
            throw new IllegalArgumentException("UserName cannot start with a numeric value.");
        }
        if (!userName.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("UserName can only contain alphabetic characters.");
        }
    }

    private void validateUserId(int userId) {
        // UserId should be a positive integer and doesn't need to be validated for alphabetic values.
        if (userId <= 0) {
            throw new IllegalArgumentException("UserId must be a positive integer.");
        }
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }
}
