package com.example.s24261bank.model;

import com.example.s24261bank.TransactionConfirmationStatus;

public class TransactionConfirmation {
    private final TransactionConfirmationStatus status;
    private final int balance;

    public TransactionConfirmation(TransactionConfirmationStatus status, int balance) {
        this.status = status;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "TransactionConfirmation{" +
                "status=" + status +
                ", balance=" + balance +
                '}';
    }
}
