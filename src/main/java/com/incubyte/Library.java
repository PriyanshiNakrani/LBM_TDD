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


    public void addBook(User user, Book book) {
        validateUser(user);
        validateBook(book);

        if (books.containsKey(book.getIsbn())) {
            duplicateBookCounter++;
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        } else {
            books.put(book.getIsbn(), book);
        }
    }

     public Map<String, Book> getBooks() {
        return new HashMap<>(books); 
    }

     public int getDuplicateBookCounter() {
        return duplicateBookCounter;
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
    }

    private void validateBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
    }
}
