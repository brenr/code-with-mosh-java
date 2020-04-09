package dev.brenr;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

    public static void main(final String[] args) {
        final int principal = promptForInt("Principal");
        final float rate = promptForFloat("Annual Interest Rate");
        final byte years = promptForByte("Period (Years)");

        final Loan loan = new Loan(principal, rate, years);
        final MortgageCalculator mortgageCalculator = new MortgageCalculator((loan));

        printMortgageSection(mortgageCalculator);
        printPaymentScheduleSection(mortgageCalculator);
    }

    private static int promptForInt(final String prompt) {
        promptMessage(prompt);
        return scanner.nextInt();
    }

    private static float promptForFloat(final String prompt) {
        promptMessage(prompt);
        return scanner.nextFloat();
    }

    private static byte promptForByte(final String prompt) {
        promptMessage(prompt);
        return scanner.nextByte();
    }

    private static void promptMessage(final String string) {
        System.out.print(string + ": ");
    }

    private static void printMortgageSection(final MortgageCalculator mc) {
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " +
                currencyFormatter.format(mc.calculateMortgage()));
    }

    private static void printPaymentScheduleSection(final MortgageCalculator mc) {
        final double[] balances = mc.getPaymentSchedule();
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        System.out.println(getPaymentScheduleString(balances));
    }

    private static final String getPaymentScheduleString(final double[] balances) {
        StringBuilder sb = new StringBuilder();
        for(double balance : balances) {
            sb.append(currencyFormatter.format(balance) + "\n");
        }
        return sb.toString();
    }

}
