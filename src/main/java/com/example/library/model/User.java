package com.example.library.model;

import java.time.LocalDate;
import java.util.*;

public class User {

    private static int nextId =1;
    private int id;
    private String userName;

    private String userLastName;

    private List<Book> userBooks = new ArrayList<>();

    public List<Book> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<Book> userBooks) {
        this.userBooks = userBooks;
    }

    public User() {

    }

    public void setId(int id) {
        this.id = id;
    }


    private final LocalDate date = LocalDate.now();

    public User(String userName, String userLastName) {
        this.id = nextId++;
        this.userName = userName;
        this.userLastName = userLastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", UserName='" + userName + '\'' +
                ", UserLastName='" + userLastName + '\'' +
                userBooks +
                '}';
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public boolean addBookToList(Book book){
        userBooks.add(book);
        return true;
    }

}
