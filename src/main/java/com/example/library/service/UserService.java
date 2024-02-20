package com.example.library.service;

import com.example.library.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users = new ArrayList<>();

    public boolean createUser(String name, String lastNAme){
        User u1 = new User(name,lastNAme);
        users.add(u1);
        return true;
    }

    public List<User> usersList(){
        return users;
    }

    public boolean changeUserInfo(int id, String name, String lastName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setUserName(name);
                users.get(i).setUserLastName(lastName);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUserFromList(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }
    public User getUserById(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        return null;
    }


}
