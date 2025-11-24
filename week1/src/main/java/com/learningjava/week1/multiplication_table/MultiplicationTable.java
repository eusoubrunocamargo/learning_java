package com.learningjava.week1.multiplication_table;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MultiplicationTable {

    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("=== Multiplication ===");

        System.out.print("Type number to see the multiplication table: ");
        int number = scanner.nextInt();

        System.out.print("Multiply until: ");
        int limit = scanner.nextInt();

        System.out.println();
        System.out.println("Table of " + number + " until " + limit + ":");

        for (int i = 1; i <= limit; i++) {
            int result = number * i;
            System.out.printf("%d * %d = %d%n", number, i, result);
        }

        System.out.println();

    }
}
