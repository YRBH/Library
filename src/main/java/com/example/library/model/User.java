package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static int nextId =1;
    private int id;
    private String UserName;
    private String UserLastName;

    private List<BookForConclusion> userBookList = new ArrayList<>();

    public List<BookForConclusion> getUserBookList() {
        return userBookList;
    }

    public void setUserBookList(List<BookForConclusion> userBookList) {
        this.userBookList = userBookList;
    }

    public User(String userName, String userLastName) {
        this.id = nextId++;
        UserName = userName;
        UserLastName = userLastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", UserName='" + UserName + '\'' +
                ", UserLastName='" + UserLastName + '\'' +
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
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public boolean addBookToList(BookForConclusion book){
        userBookList.add(book);
        return true;
    }

}
