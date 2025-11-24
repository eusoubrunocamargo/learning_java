package com.learningjava.week1.imc_calculator;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CalculateIMC {

    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===IMC Calculator===");

        System.out.print("Enter your weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height (m): ");
        double height = scanner.nextDouble();

        double imc = calculate(weight,height);

        System.out.printf("Your IMC is: %.2f%n", imc);
        System.out.println("Classification: " + classify(imc));
        System.out.println();
    }

    private double calculate(double weight, double height){

        if(height > 3) {
            height = height / 100;
        }
        return weight / (height*height);

    }

    private String classify(double imc){
        if (imc < 18.5) {
            return "Underweight";
        } else if (imc < 25) {
            return "Normal weight";
        } else if (imc < 30) {
            return "Overweight";
        } else if (imc < 35) {
            return "Obesity Level I";
        } else if (imc < 40) {
            return "Obesity Level II";
        } else {
            return "Obesity Level III";
        }
    }
}
