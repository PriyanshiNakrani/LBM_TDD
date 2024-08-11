package com.incubyte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
    private String libName;
    private Map<String, Book> books;
    private int duplicateBookCounter;
    private Map<Book, Integer> bookDB;
    private Map<User, Set<Book>> userBooks;
    private Set<User> registeredUsers;


    public Library(String libName) {
        validateLibName(libName);
        this.libName = libName;
        this.books = new HashMap<>();
        this.duplicateBookCounter = 0;
        this.bookDB = new HashMap<>();
        this.userBooks = new HashMap<>();
        this.registeredUsers = new HashSet<>();
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

        if (bookDB.containsKey(book)) {
            bookDB.put(book, bookDB.get(book) + 1);
            throw new IllegalArgumentException("Book with this ISBN already exists.");

        } else {
            bookDB.put(book, 1);
            books.put(book.getIsbn(), book);
        }
    }

    public Map<String, Book> getBooks() {
        return new HashMap<>(books);
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

    public List<Book> showBooks() {
        return Collections.unmodifiableList(new ArrayList<>(books.values()));
    }

    public void borrowBook(Book book, User user) {
        if (book == null || user == null) {
            throw new IllegalArgumentException("Book and user cannot be null.");
        }
    
        if (!registeredUsers.contains(user)) {
            throw new IllegalArgumentException("User is not registered.");
        }
    
        if (!userBooks.containsKey(user)) {
            userBooks.put(user, new HashSet<>());
        }
    
        Set<Book> borrowedBooks = userBooks.get(user);
    
        if (borrowedBooks.contains(book)) {
            throw new IllegalArgumentException("Book is already borrowed by the user.");
        }
    
        if (!bookDB.containsKey(book) || bookDB.get(book) == 0) {
            throw new IllegalArgumentException("Book is not available.");
        }
    
        if (borrowedBooks.size() >= 2) {
            throw new IllegalArgumentException("User can only borrow up to 2 books.");
        }
    
        bookDB.put(book, bookDB.get(book) - 1);
        borrowedBooks.add(book);
    }

    public Map<Book, Integer> getBookDB() {
        return Collections.unmodifiableMap(bookDB);
    }

    public void registerUser(User user) {
        validateUser(user);
        registeredUsers.add(user);
    }

    public void returnBook(Book book, User user) {
        if (book == null || user == null) {
            throw new IllegalArgumentException("Book and user cannot be null.");
        }
    
        if (!registeredUsers.contains(user)) {
            throw new IllegalArgumentException("User is not registered.");
        }
    
        if (!bookDB.containsKey(book)) {
            throw new IllegalArgumentException("Book is not in the library.");
        }
    
        if (!userBooks.containsKey(user)) {
            throw new IllegalArgumentException("Book was not borrowed by this user.");
        }
    
        Set<Book> borrowedBooks = userBooks.get(user);
    
        if (!borrowedBooks.contains(book)) {
            throw new IllegalArgumentException("Book was already returned by this user.");
        }
    
        borrowedBooks.remove(book);
    
        bookDB.put(book, bookDB.get(book) + 1);
    
        if (borrowedBooks.isEmpty()) {
            userBooks.remove(user);
        }
    }
    
    
    
    
    
}
