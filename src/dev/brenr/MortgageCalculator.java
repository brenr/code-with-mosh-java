package dev.brenr;

public class MortgageCalculator {

    private Loan loan;

    public MortgageCalculator(final Loan loan) {
        this.loan = loan;
    }

    public double calculateMortgage() {
        final double onePlusRatePowN = Math.pow(1 + loan.getRate(), loan.getPeriod());
        return loan.getPrincipal() *
                ((loan.getRate() * onePlusRatePowN)
                / (onePlusRatePowN - 1));
    }

    private double calculateRemainingBalance() {
        return loan.getPrincipal() *
                (getPrincipalInterest() - getPaidInterest())
                / (getPrincipalInterest() - 1);
    }

    private double getPrincipalInterest() {
        return Math.pow(1 + loan.getRate(), loan.getPeriod());
    }

    private double getPaidInterest() {
        return Math.pow(1 + loan.getRate(), loan.getPaymentsMade());
    }

    public double[] getPaymentSchedule() {
        final double[] balances = new double[loan.getPeriod()];
        for(short i = 0; i < balances.length; loan.setPaymentsMade(++i)) {
            balances[i] = calculateRemainingBalance();
        }
        return balances;
    }

}
