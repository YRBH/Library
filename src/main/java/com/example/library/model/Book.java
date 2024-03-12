package com.example.library.model;

import java.sql.Date;

public class Book {
//    private Date addedDate;

//    public Date getAddedDate() {
//        return addedDate;
//    }
//
//    public void setAddedDate(Date addedDate) {
//        this.addedDate = addedDate;
//    }

    private static int nextId =1;
    private int id;

    private String author;
    private String year;
    private String name;

    private boolean isActive;

    public Book() {

    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Book(String author, String year, String name) {
        this.id = nextId++;
        this.author = author;
        this.year = year;
        this.name = name;
        this.isActive = true;
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

