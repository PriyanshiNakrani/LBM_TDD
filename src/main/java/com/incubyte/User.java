package com.incubyte;

public class User {
    private String UserName;
    private int UserId;

    public User(String UserName, int UserId) {
        validateUserNameAndUserId(UserName, UserId);
        this.UserName = UserName;
        this.UserId = UserId;
    }

    private void validateUserNameAndUserId(String UserName,int UserId) {
        if (UserName == null) {
            throw new IllegalArgumentException("UserName cannot be null.");
        }

        if (UserName.length() <= 3) {
            throw new IllegalArgumentException("UserName must be longer than 3 characters.");
        }

        if (!UserName.matches("^[a-zA-Z].*")) {
            throw new IllegalArgumentException("UserName cannot start with a numeric value.");
        }

        if (!UserName.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("UserName can only contain alphabetic characters.");
        }

        // `UserId` is an `int`, it can't be null.
        if (String.valueOf(UserId).matches("^[a-zA-Z].*")) {
            throw new IllegalArgumentException("UserId cannot start with an alphabetic value.");
        }
    }
}
