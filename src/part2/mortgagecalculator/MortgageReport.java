package part2.mortgagecalculator;

import java.text.NumberFormat;

public class MortgageReport {

    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

    private MortgageCalculator calculator;

    public MortgageReport(final MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgageSection() {
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " +
                currencyFormatter.format(calculator.calculateMortgage()));
    }

    public void printPaymentScheduleSection() {
        System.out.println("\nPAYMENT SCHEDULE\n----------------");

        StringBuilder paymentScheduleString = new StringBuilder();
        for(double balance : calculator.getPaymentSchedule()) {
            paymentScheduleString.append(
                    currencyFormatter.format(balance) + "\n");
        }

        System.out.println(paymentScheduleString.toString());
    }
}
