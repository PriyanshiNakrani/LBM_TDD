package com.incubyte;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, String isbn, int publicationYear) {
        validateTitleAndAuthor(title, author);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    private void validateTitleAndAuthor(String title, String author) {
        if (title == null || author == null) {
            throw new IllegalArgumentException("Title and Author cannot be null.");
        }

        if (title.matches("^[0-9].*") || author.matches("^[0-9].*")) {
            throw new IllegalArgumentException("Title and Author cannot start with a numeric value.");
        }

        if (title.matches("^[0-9]+$") || author.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Title and Author cannot contain only numeric values.");
        }
    }
}
