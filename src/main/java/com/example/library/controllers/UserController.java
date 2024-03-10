package com.example.library.controllers;

import com.example.library.model.User;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public boolean createUser(@RequestBody Map<String, String> map) {
        System.out.println(map);
        String name = map.get("name");
        String lastName = map.get("lastname");
        if (name.isEmpty() || lastName.isEmpty()){
            return false;
        }
         userService.addUserToDataBase(name, lastName);
        return true;
    }

    @GetMapping("/user")
    public List<User> showUsers() throws SQLException {
        return userService.viewUsers();
    }

    @PutMapping("/user/{id}")
    public boolean changeUserInfo(@PathVariable int id, @RequestBody Map<String,String> map)  {
        String name = map.get("userName");
        String lastName = map.get("userLastName");
        if (name.isEmpty() || lastName.isEmpty()){
            return false;
        }

        userService.changeUserInfo(id, name, lastName);
        return true;
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUserFromList(id);
    }
    @GetMapping("/user/{id}")
    public User showUserById(@PathVariable int id) throws SQLException {
        return userService.getUserById(id);
    }

}
