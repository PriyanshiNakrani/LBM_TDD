package com.incubyte;

public class Book {
    private String Isbn;
    private String Title;
    private String Author;
    private int PublicationYear;

    public Book(){
        throw new IllegalArgumentException("Constructor arguments can not be null");
    }
}
