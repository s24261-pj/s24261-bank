package com.example.s24261bank.storage;

import com.example.s24261bank.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private final List<User> userList = new ArrayList<>();

    public UserStorage() {
        this.userList.addAll(List.of(
            new User("1", "Marek Kowalski", 1000),
            new User("2", "Darek Kowal", 2000),
            new User("3", "Irek Motyl", 500)
        ));
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUserByUuid(String userUuid) {
        for (User user : getUserList()) {
            if (user.getUuid().equals(userUuid)) {
                return user;
            }
        }

        return null;
    }

    public void addNewUser(String name, int balance) {
        this.userList.add(new User(null, name, balance));
    }
}
