package com.incubyte;

/**
 * Represents a Book with title, author, ISBN, and publication year.
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;

    /**
     * Creates a new Book with the specified details.
     *
     * @param title           the title of the book
     * @param author          the author of the book
     * @param isbn            the ISBN of the book (must be exactly 13 digits)
     * @param publicationYear the year the book was published (must be a 4-digit year)
     */
    public Book(String title, String author, String isbn, int publicationYear) {
        validateBookDetails(title, author, isbn, publicationYear);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    private void validateBookDetails(String title, String author, String isbn, int publicationYear) {
        validateNonNullAndNotEmpty(title, "Title");
        validateNonNullAndNotEmpty(author, "Author");
        validateTitleAndAuthor(title, author);
        validateIsbn(isbn);
        validatePublicationYear(publicationYear);
    }

    private void validateNonNullAndNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty.");
        }
    }

    private void validateTitleAndAuthor(String title, String author) {
        if (title.matches("^[0-9].*") || author.matches("^[0-9].*")) {
            throw new IllegalArgumentException("Title and Author cannot start with a numeric value.");
        }

        if (title.matches("^[0-9]+$") || author.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Title and Author cannot contain only numeric values.");
        }
    }

    private void validateIsbn(String isbn) {
        if (isbn == null) {
            throw new IllegalArgumentException("ISBN cannot be null.");
        }

        if (!isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN must be exactly 13 digits long and contain only numeric values.");
        }
    }

    private void validatePublicationYear(int publicationYear) {
        String publicationYearStr = String.valueOf(publicationYear);

        if (!publicationYearStr.matches("\\d{4}")) {
            throw new IllegalArgumentException("Publication year must be exactly 4 digits and contain only numeric values.");
        }
    }
}
