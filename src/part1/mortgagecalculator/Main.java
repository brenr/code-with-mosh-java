package mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private static final Scanner scanner = new Scanner(System.in);
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {

        final int principalAmount = (int)readNumber(
                "Principal: ",
                1_000,
                1_000_000);
        final float annualInterest = (int)readNumber(
                "Annual Interest Rate: ",
                1,
                30);
        final byte years = (byte)readNumber(
                "Period (Years): ",
                1,
                30);


        // Print mortgage section
        printMortgageSection(principalAmount, annualInterest, years);

        // Print payment schedule section
        printPaymentScheduleSection(principalAmount, annualInterest, years);
    }

    private static void printPaymentScheduleSection(
            final int principalAmount,
            final float annualInterest,
            final byte years) {

        final double[] balances = getPaymentSchedule(principalAmount, annualInterest, years);
        System.out.println("\nPAYMENT SCHEDULE\n" + "----------------" +
                           "\n" + getPaymentScheduleString(balances));
    }

    private static void printMortgageSection(
            final int principalAmount,
            final float annualInterest,
            final byte years) {

        final double mortgage = calculateMortgage(principalAmount, annualInterest, years);
        System.out.println("\nMORTGAGE\n" + "--------" +
                           "\nMonthly Payments: " + currencyFormatter.format(mortgage));
    }

    private static double calculateMortgage(
            final int principalAmount,
            final float annualInterest,
            final byte years) {

        final double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        final short payments = (short)(years * MONTHS_IN_YEAR);
        final double onePlusRatePowN = Math.pow(1 + monthlyInterest, payments);

        return principalAmount *
                ((monthlyInterest * onePlusRatePowN)
                / (onePlusRatePowN - 1));
    }

    private static double calculateRemainingBalance(
            final int principalAmount,
            final double annualInterest,
            final short years,
            final short paymentsMadeToDate) {

        final double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        final short principalPayments = (short)(years * MONTHS_IN_YEAR);

        final double rate = 1 + monthlyInterest;
        final double principalInterest = Math.pow(rate, principalPayments);
        final double paidInterest = Math.pow(rate, paymentsMadeToDate);

        return principalAmount *
                (principalInterest - paidInterest)
                / (principalInterest - 1);
    }

    private static double[] getPaymentSchedule(
            final int principal,
            final double annualInterest,
            final byte years) {

        final short principalPayments = (short) (years * MONTHS_IN_YEAR);
        final double[] balances = new double[principalPayments];

        for(short i = 0; i < balances.length; i++) {
            balances[i] = calculateRemainingBalance(
                    principal,
                    annualInterest,
                    years,
                    ((short)(i + 1)));
        }

        return balances;
    }

    private static final String getPaymentScheduleString(final double[] balances) {
        StringBuilder sb = new StringBuilder();
        for(double balance : balances) {
            sb.append(currencyFormatter.format(balance) + "\n");
        }

        return sb.toString();
    }

    private static double readNumber(String prompt, double min, double max) {
        double value;

        while(true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max) {
                return value;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
    }

}
