package com.learningjava.week2.account;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Account {

    private final String accountNumber;
    private String holderName;
    private BigDecimal balance;

    protected Account(String accountNumber, String holderName, BigDecimal balance) {
        this.accountNumber = Objects.requireNonNull(accountNumber, "cannot be null");
        this.holderName = Objects.requireNonNull(holderName, "cannot be null");
        this.balance = balance == null ? BigDecimal.ZERO : balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = Objects.requireNonNull(holderName, "cannot be null");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    protected void setBalance(BigDecimal newBalance) {
        this.balance = newBalance;
    }

    public void deposit(BigDecimal amount) {
        Objects.requireNonNull(amount, "cannot be null");
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        Objects.requireNonNull(amount, "cannot be null");
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        }
        this.balance = this.balance.subtract(amount);
    }

    public void transferTo(Account destination, BigDecimal amount) {
        Objects.requireNonNull(destination, "destination cannot be null");
        Objects.requireNonNull(amount, " amount cannot be null");
        this.withdraw(amount);
        destination.deposit(amount);
    }

    @Override
    public String toString() {
        return """
                Account {
                accountNumber: %s,
                holderName: %s,
                balance: %.2f
                }
                """.formatted(accountNumber, holderName, balance);
    }
}
