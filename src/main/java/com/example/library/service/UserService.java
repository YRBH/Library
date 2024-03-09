package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public boolean addUserToDataBase(String userName, String userLastName) {
        if (userName.isEmpty() || userLastName.isEmpty()) {
            return false;
        }

        String url = "jdbc:mysql://localhost:3306/books";
        String username = "root";
        String password = "root";
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

        String url = "jdbc:mysql://localhost:3306/books";
        String user = "root";
        String password = "root";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
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

//    public boolean changeUserInfo(int id, String name, String lastName) {
//        if (name.isEmpty() || lastName.isEmpty()){
//            return false;
//        }
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId() == id) {
//                users.get(i).setUserName(name);
//                users.get(i).setUserLastName(lastName);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean deleteUserFromList(int id) {
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId() == id) {
//                users.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
//    public User getUserById(int id) {
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId() == id) {
//                return users.get(i);
//            }
//        }
//        return null;
//    }


}
