package com.incubyte;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private String libName;
    private Map<String, Book> books;
    private int duplicateBookCounter;

    public Library(String libName) {
        validateLibName(libName);
        this.libName = libName;
        this.books = new HashMap<>();
        this.duplicateBookCounter = 0;
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
