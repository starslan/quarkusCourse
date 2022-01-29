package org.agoncal.quarkus.starting.entity;

public class Book {

    public Long id;
    public String title;
    public String author;
    public int yearOfPublication;
    public String genre;

    public Book(Long id, String title, String author, int yearOfPublication, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }
}
