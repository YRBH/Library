package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    String url = "jdbc:mysql://localhost:3306/books";
    String username = "root";
    String password = "root";

    public boolean addUserToDataBase(String userName, String userLastName) {
        if (userName.isEmpty() || userLastName.isEmpty()) {
            return false;
        }
        String query = "INSERT INTO user (userName, userLastName) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, userName);
            statement.setString(2, userLastName);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<User> viewUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM user");

            while (rs.next()) {
                User users1 = new User();
                users1.setId(rs.getInt("id"));
                users1.setUserName(rs.getString("userName"));
                users1.setUserLastName(rs.getString("userLastName"));

                users.add(users1);

            }
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }

        return users;
    }

    public boolean changeUserInfo(int id, String name, String lastName) {
        if (name.isEmpty() || lastName.isEmpty()){
            return false;
        }

        Connection conn = null;
        PreparedStatement ps = null;

        try {
        conn = DriverManager.getConnection(url,username,password);
        String q = "UPDATE user SET username = ?, userLastName = ? WHERE id = ?";
            ps = conn.prepareStatement(q);
            ps.setString(1,name);
            ps.setString(2,lastName);
            ps.setInt(3,id);

            int rowsAffected = ps.executeUpdate();
            ps.close();
            conn.close();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUserFromList(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(url,username,password);
            String q = "DELETE FROM user WHERE id = ?";
            ps = conn.prepareStatement(q);
            ps.setInt(1,id);

            int roweAddected = ps.executeUpdate();
            ps.close();
            conn.close();
            return roweAddected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public User getUserById(int id) throws SQLException {
        User user = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM user WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setUserLastName(rs.getString("userLastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return user;
    }


}
