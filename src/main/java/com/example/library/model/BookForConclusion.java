package com.example.library.model;

public class BookForConclusion {

    private static int nextId =1;
    private int id;

    private String author;
    private String year;
    private String name;

    public BookForConclusion() {
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return "BoolForConclusion{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
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
