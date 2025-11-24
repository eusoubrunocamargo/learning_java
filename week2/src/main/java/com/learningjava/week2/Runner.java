package com.learningjava.week2;

import com.learningjava.week2.account.Account;
import com.learningjava.week2.bank.Bank;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner {

    private final Bank bank;

    public Runner(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("running bank...");
        System.out.println("=== testing Account.transferTo ===");

        Account origin = new Account("001", "Alice", BigDecimal.valueOf(1000)) {};
        Account destination = new Account("002", "Bob", BigDecimal.ZERO) {};

        System.out.println("before transfer:");
        System.out.println(origin);
        System.out.println(destination);

        origin.transferTo(destination, BigDecimal.valueOf(250));

        System.out.println("after transfer of 250:");
        System.out.println(origin);
        System.out.println(destination);


    }
}
