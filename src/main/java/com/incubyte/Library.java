package com.incubyte;

public class Library {
    private String libName;

    public Library(String libName) {
        validateLibName(libName);
        this.libName = libName;
    }

    private void validateLibName(String libName) {
        if (libName == null) {
            throw new IllegalArgumentException("Library name cannot be null.");
        }

        if (libName.length() <= 3) {
            throw new IllegalArgumentException("Library name must be longer than 3 characters.");
        }

        if (libName.matches("^[0-9].*")) {
            throw new IllegalArgumentException("Library name cannot start with a numeric value.");
        }

        if (libName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Library name cannot contain numeric values.");
        }
    }
}
