package com.learningjava.week2.saving_account;

import com.learningjava.week2.account.Account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class SavingsAccount extends Account {

    private BigDecimal monthlyInterestRate;
    private LocalDate lastDepositDate;

    public SavingsAccount(
            String accountNumber,
            String holderName,
            BigDecimal monthlyInterestRate) {
        super(accountNumber, holderName);
        this.monthlyInterestRate = Objects.requireNonNull(monthlyInterestRate, "cannot be null");
    }
}
