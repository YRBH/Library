package com.example.library.service;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.example.library.model.Book;
import com.example.library.model.BookForConclusion;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final String url = "jdbc:mysql://localhost:3306/books";
    private final  String user = "root";
    private final String password = "root";

    public List<Book> viewBook() {
        List<Book> books = new ArrayList<>();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM book");

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setAuthor(rs.getString("author"));
                book.setYear(rs.getString("year"));
                book.setName(rs.getString("name"));
                books.add(book);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public boolean addBookToDataBase(String author, String year, String nameBook) {
        if (author.isEmpty() || year.isEmpty() || nameBook.isEmpty()) {
            return false;
        }

        String query = "INSERT INTO book (author, year, name) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, author);
            statement.setString(2, year);
            statement.setString(3, nameBook);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Book findBookById(int id) throws SQLException {
        Book book = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM book WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setAuthor(rs.getString("author"));
                book.setYear(rs.getString("year"));
                book.setName(rs.getString("name"));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return book;
    }

    public boolean deleteBookById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM book WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    public boolean updateBook(int id, String author, String year, String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "UPDATE book SET author = ?, year = ?, name = ? WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, author);
            ps.setString(2, year);
            ps.setString(3, name);
            ps.setInt(4, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

}


