package com.learningjava.week1;

import com.learningjava.week1.bank.Bank;
import com.learningjava.week1.imc_calculator.CalculateIMC;
import com.learningjava.week1.multiplication_table.MultiplicationTable;
import com.learningjava.week1.user_greeting.UserGreeting;
import com.learningjava.week1.voting_elegibility.VotingEligibility;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final CalculateIMC calculateIMC;
    private final UserGreeting userGreeting;
    private final MultiplicationTable multiplicationTable;
    private final VotingEligibility votingEligibility;
    private final Bank bank;


    public Runner(CalculateIMC calculateIMC,
                  UserGreeting userGreeting,
                  MultiplicationTable multiplicationTable,
                  VotingEligibility votingEligibility,
                  Bank bank){
        this.calculateIMC = calculateIMC;
        this.userGreeting = userGreeting;
        this.multiplicationTable = multiplicationTable;
        this.votingEligibility = votingEligibility;
        this.bank = bank;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Main Menu");
            System.out.println("1 – Calculate IMC");
            System.out.println("2 – Greet User");
            System.out.println("3 – Multiplication Table");
            System.out.println("4 – Voting Eligibility");
            System.out.println("5 - Bank");
            System.out.println("0 - Quit");
            System.out.print("Choose one option: ");

            while (!scanner.hasNextInt()){
                System.out.println("Invalid option. Type a number.");
                scanner.next();
                System.out.print("Choose one option: ");
            }

            option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (option) {
                case 1 -> calculateIMC.execute();
                case 2 -> userGreeting.execute();
                case 3 -> multiplicationTable.execute();
                case 4 -> votingEligibility.execute();
                case 5 -> bank.execute();
                case 0 -> System.out.println("Closing application...");
                default -> System.out.println("Invalid option. Try again. \n");
            }
        } while (option != 0);
    }
}
