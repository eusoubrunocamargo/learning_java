package com.learningjava.week2.bank;

import com.learningjava.week2.account.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Bank {

    private String name;
    private String address;
    private String code;

    private final List<Account> accounts = new ArrayList<>();

//    public Bank(String name, String address, String code) {
//        this.name = Objects.requireNonNull(name, "cannot be null");
//        this.address = Objects.requireNonNull(address, "cannot be null");
//        this.code = Objects.requireNonNull(code, "cannot be null");
//    }

    public Bank() {
        this.name = "Week 2 Bank";
        this.address = "Nowhere";
        this.code = "999";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "cannot be null");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = Objects.requireNonNull(address, "cannot be null");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = Objects.requireNonNull(code, "cannot be null");
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(Objects.requireNonNull(account, "cannot be null"));
    }

    public Account findAccount(String accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }
}
