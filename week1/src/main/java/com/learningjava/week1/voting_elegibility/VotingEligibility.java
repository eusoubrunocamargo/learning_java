package com.learningjava.week1.voting_elegibility;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class VotingEligibility {

    private final Scanner scanner = new Scanner(System.in);

    public void execute() {

        System.out.println("Verify Eligibility");

        System.out.print("Enter your age: ");

        int age = scanner.nextInt();

        String result = getVotingStatus(age);

        System.out.println("Informed age: " + age + " years old.");
        System.out.println("Electoral situation: " + result);
        System.out.println();
    }

    private String getVotingStatus(int age) {
        if(age < 16) {
            return "You can't vote.";
        } else if (age >= 18 && age <= 70) {
            return "Required to vote.";
        } else {
            return "Optional.";
        }
    }
}
