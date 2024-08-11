package com.incubyte;

import java.util.*;

/**
 * Represents a Library with operations to manage books and users.
 */
public class Library {
    private final String libName;
    private final Map<String, Book> books;
    private final Map<Book, Integer> bookDB;
    private final Map<User, Set<Book>> userBooks;
    private final Set<User> registeredUsers;

    /**
     * Creates a new Library with a given name.
     *
     * @param libName the name of the library
     */
    public Library(String libName) {
        validateLibName(libName);
        this.libName = libName;
        this.books = new HashMap<>();
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
        if (libName.matches("^[0-9].*") || libName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Library name cannot start with a numeric value or contain numeric values.");
        }
    }

    /**
     * Adds a book to the library.
     *
     * @param user the user adding the book
     * @param book the book to add
     */
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
        return Collections.unmodifiableMap(books);
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

    /**
     * Shows all the books in the library.
     *
     * @return an unmodifiable list of books
     */
    public List<Book> showBooks() {
        return Collections.unmodifiableList(new ArrayList<>(books.values()));
    }

    /**
     * Borrows a book from the library.
     *
     * @param book the book to borrow
     * @param user the user borrowing the book
     */
    public void borrowBook(Book book, User user) {
        if (book == null || user == null) {
            throw new IllegalArgumentException("Book and user cannot be null.");
        }
        if (!registeredUsers.contains(user)) {
            throw new IllegalArgumentException("User is not registered.");
        }
        userBooks.computeIfAbsent(user, k -> new HashSet<>());

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

    /**
     * Registers a user with the library.
     *
     * @param user the user to register
     */
    public void registerUser(User user) {
        validateUser(user);
        registeredUsers.add(user);
    }

    /**
     * Returns a borrowed book to the library.
     *
     * @param book the book to return
     * @param user the user returning the book
     */
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

        Set<Book> borrowedBooks = userBooks.get(user);
        if (borrowedBooks == null || !borrowedBooks.contains(book)) {
            throw new IllegalArgumentException("Book was not borrowed by this user.");
        }

        borrowedBooks.remove(book);
        bookDB.put(book, bookDB.get(book) + 1);

        if (borrowedBooks.isEmpty()) {
            userBooks.remove(user);
        }
    }
}
