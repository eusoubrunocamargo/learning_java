package com.learningjava.week1.user_greeting;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Scanner;

@Component
public class UserGreeting {

    private final Scanner scanner = new Scanner(System.in);

    public void execute() {

        System.out.println("=== Hello! ===");

        System.out.print("Type your name: ");
        String name = scanner.nextLine();

        String greeting = getGreetingByTime();
        System.out.println(greeting + ", " + name + "!");
        System.out.println("Welcome to the system!");
        System.out.println();
    }

    private String getGreetingByTime(){

        LocalTime now = LocalTime.now();

        if(now.isBefore(LocalTime.NOON)){
            return "Good Morning!";
        } else if(now.isBefore(LocalTime.of(18, 0))){
            return "Good Afternoon!";
        } else {
            return "Good Night!";
        }
    }
}
