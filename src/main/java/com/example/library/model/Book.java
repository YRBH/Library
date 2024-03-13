package com.example.library.model;

public class Book {

    private static int nextId =1;
    private int id;

    private String author;
    private String year;
    private String name;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Book() {

    }


    public Book(String author, String year, String name) {
        this.id = nextId++;
        this.author = author;
        this.year = year;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId(int id) {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

