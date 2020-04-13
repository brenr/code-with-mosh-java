package dev.brenr.util;

import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    public double promptForNumber(final String prompt) {
        promptMessage(prompt);
        return scanner.nextDouble();
    }

    public double promptForNumber(
            final String prompt,
            final double min,
            final double max) {

        double number;
        while((number = promptForNumber(prompt)) < min || number > max) {
            System.out.println(prompt + " must be between " + min + " and " + max + ".");
        }

        return number;
    }

    public void promptMessage(final String string) {
        System.out.print(string + ": ");
    }

}
