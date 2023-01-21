package com.example.s24261bank.service;

import com.example.s24261bank.model.User;
import com.example.s24261bank.storage.UserStorage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserStorage userStorage;

    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public List<User> getUserList() {
        return this.userStorage.getUserList();
    }

    public User getUserByUuid(String userUuid) {
        User searchedUser = this.userStorage.getUserByUuid(userUuid);

        if (searchedUser == null) return null;

        return searchedUser;
    }

    public void registerUser(String name, int balance) {
        this.userStorage.addNewUser(name, balance);
    }
}
