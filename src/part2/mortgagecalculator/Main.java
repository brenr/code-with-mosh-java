package part2.mortgagecalculator;

import part2.util.Console;

public class Main {

    private static final Console console = new Console();

    public static void main(final String[] args) {

        final int principal = (int) console.promptForNumber("Principal", 0, 1_000_000);
        final float rate = (float) console.promptForNumber("Annual Interest Rate", 0.1, 10);
        final byte period = (byte) console.promptForNumber("Period (Years)", 1, 30);

        final Loan loan = new Loan(principal, rate, period);
        final MortgageCalculator mortgageCalculator = new MortgageCalculator(loan);
        final MortgageReport report = new MortgageReport(mortgageCalculator);

        report.printMortgageSection();
        report.printPaymentScheduleSection();
    }

}
