package com.example.s24261bank;

import com.example.s24261bank.model.TransactionConfirmation;
import com.example.s24261bank.model.User;
import com.example.s24261bank.service.TransactionService;
import com.example.s24261bank.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S24261BankApplication {

	public S24261BankApplication(TransactionService transactionService, UserService userService) {
		System.out.println(userService.getUserList());
		userService.registerUser("Tadeusz", 8000);
		System.out.println(userService.getUserList());

		TransactionConfirmation removeMoneyTransaction = transactionService.addMoney("1", 500);
		System.out.println(removeMoneyTransaction);

		TransactionConfirmation addMoneyTransaction = transactionService.removeMoney("1", 300);
		System.out.println(addMoneyTransaction);

		User userByUuid = userService.getUserByUuid("1");
		System.out.println(userByUuid);
	}

	public static void main(String[] args) {
		SpringApplication.run(S24261BankApplication.class, args);
	}

}
