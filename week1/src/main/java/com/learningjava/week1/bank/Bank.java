package com.learningjava.week1.bank;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class Bank {

    private final Scanner scanner = new Scanner(System.in);
    private BigDecimal balance = BigDecimal.ZERO;

    public void execute() {

        int option;

        do {
            System.out.println("=== Bank Menu ===");
            System.out.println("1 - Check balance");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("0 - Back to Main Menu");
            System.out.print("Choose one option: ");

            while(!scanner.hasNextInt()) {
                System.out.println("Invalid option. Please enter a number.");
                scanner.next();
                System.out.print("Choose one option: ");
            }

            option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (option) {
                case 1 -> showBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 0 -> System.out.println("Invalid option. Try again.");
            }

            System.out.println();

        } while (option != 0);
    }

    private void showBalance() {
        System.out.printf("Current balance: R$ %.2f%n", balance);
    }

    private void deposit() {
        System.out.print("Amount to deposit: R$ ");
        BigDecimal amount = readPositiveAmount();

        balance = balance.add(amount);
        System.out.printf("Deposit successful. New balance: R$ %.2f%n", balance);
    }

    private void withdraw() {
        System.out.print("Amount to withdraw: R$ ");
        BigDecimal amount = readPositiveAmount();

        if(amount.compareTo(balance) > 0) {
            System.out.printf("Insufficient funds. Your balance is: R$ %.2f%n", balance);
            return;
        }

        balance = balance.subtract(amount);
        System.out.printf("Withdrawal successful. New balance: R$ %.2f%n", balance);
    }

    private BigDecimal readPositiveAmount() {

        while(true) {

            while (!scanner.hasNextBigDecimal()) {
                System.out.println("Invalid value. Please enter a numeric amount.");
                scanner.next();
                System.out.print("Amount: R$ ");
            }

            BigDecimal value = scanner.nextBigDecimal();
            scanner.nextLine();

            if(value.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.print("Amount must be greater than zero. Try again: R$ ");
            } else {
                return value;
            }
        }
    }
}
