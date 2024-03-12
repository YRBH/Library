package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BookForConclusion;
import com.example.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;


@Service
public class LibraryService {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    private final String url = "jdbc:mysql://localhost:3306/books";
    private final  String user = "root";
    private final String password = "root";


    public boolean userTakeBook(int userId, int bookId) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(url,user,password);
            String q = "UPDATE book SET user_id = ? WHERE id = ?";
            ps = conn.prepareStatement(q);
            ps.setString(1, String.valueOf(userId));
            ps.setString(2, String.valueOf(bookId));

            int rowsInserted = ps.executeUpdate();
            ps.close();
            conn.close();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean returnUserBook(int bookId){

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
            String q = "UPDATE book SET user_id = null WHERE id = ?";
            ps = conn.prepareStatement(q);
            ps.setString(1, String.valueOf(bookId));

            int rowsInserted = ps.executeUpdate();
            ps.close();
            conn.close();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
