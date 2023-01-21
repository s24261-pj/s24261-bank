package com.example.s24261bank.model;

import java.util.UUID;

public class User {
    private final String uuid;
    private final String name;
    private int balance;

    public User(String uuid, String name, int balance) {
        this.uuid = uuid == null ? getRandomUUID() : uuid;
        this.name = name;
        this.balance = balance;
    }

    public String getUuid() {
        return uuid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
