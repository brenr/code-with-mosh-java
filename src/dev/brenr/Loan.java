package dev.brenr;

public class Loan {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private int principal;
    private float rate;
    private short period;
    private short paymentsMade;

    public Loan(final int principal, final float rate, final byte years) {
        setPrincipal(principal);
        setRate(rate);
        setPeriod(years);
    }

    private void setPrincipal(final int principal) {
        if(principal <= 0) {
            throw new IllegalArgumentException("Principal amount cannot be zero or less.");
        }
        this.principal = principal;
    }

    private void setRate(final float rate) {
        if(rate <= 0) {
            throw new IllegalArgumentException("Rate cannot be zero or less.");
        }
        this.rate = rate / PERCENT / MONTHS_IN_YEAR;
    }

    private void setPeriod(final byte years) {
        if(years <= 0) {
            throw new IllegalArgumentException("Period cannot be zero or less.");
        }
        this.period = (short) (years * MONTHS_IN_YEAR);
    }

    public void setPaymentsMade(final short paymentsMade) {
        if(paymentsMade < 0 || paymentsMade > period) {
            throw new IllegalArgumentException("Payments made cannot be less than zero or more than the period");
        }
        this.paymentsMade = paymentsMade;
    }

    public int getPrincipal() {
        return this.principal;
    }

    public float getRate() {
        return this.rate;
    }

    public short getPeriod() {
        return this.period;
    }

    public short getPaymentsMade() {
        return this.paymentsMade;
    }

}