package com.example.s24261bank.service;

import com.example.s24261bank.TransactionConfirmationStatus;
import com.example.s24261bank.model.TransactionConfirmation;
import com.example.s24261bank.model.User;
import com.example.s24261bank.storage.UserStorage;
import org.springframework.stereotype.Component;

@Component
public class TransactionService {
    private final UserStorage userStorage;

    public TransactionService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public TransactionConfirmation addMoney(String userUuid, int transactionAmount) {
        User searcheduser = this.userStorage.getUserByUuid(userUuid);

        if (searcheduser == null) {
            return new TransactionConfirmation(TransactionConfirmationStatus.DECLINED, 0);
        }

        int newUserBalance = searcheduser.getBalance() + Math.abs(transactionAmount);
        if (newUserBalance <= 0) {
            return new TransactionConfirmation(TransactionConfirmationStatus.DECLINED, 0);
        }

        searcheduser.setBalance(newUserBalance);

        return new TransactionConfirmation(TransactionConfirmationStatus.ACCEPTED, searcheduser.getBalance());
    }

    public TransactionConfirmation removeMoney(String userUuid, int transactionAmount) {
        User searcheduser = this.userStorage.getUserByUuid(userUuid);

        if (searcheduser == null || searcheduser.getBalance() <= 0) {
            return new TransactionConfirmation(TransactionConfirmationStatus.DECLINED, 0);
        }

        int newUserBalance = searcheduser.getBalance() - Math.abs(transactionAmount);
        if (newUserBalance <= 0) {
            return new TransactionConfirmation(TransactionConfirmationStatus.DECLINED, 0);
        }

        searcheduser.setBalance(newUserBalance);

        return new TransactionConfirmation(TransactionConfirmationStatus.ACCEPTED, searcheduser.getBalance());
    }
}
