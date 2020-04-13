package dev.brenr.mortgagecalculator;

public class Loan {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private int principal;
    private float annualRate;
    private float monthlyRate;
    private short period;
    private short paymentsMade;

    public Loan(final int principal, final float annualRate, final byte years) {
        setPrincipal(principal);
        setAnnualRate(annualRate);
        setPeriod(years);
    }

    public void setPrincipal(final int principal) {
        if(principal <= 0) {
            throw new InstantiationError("Principal amount cannot be zero or less.");
        }
        this.principal = principal;
    }

    public void setAnnualRate(final float annualRate) {
        if(annualRate <= 0) {
            throw new InstantiationError("Rate cannot be zero or less.");
        }
        this.annualRate = annualRate / PERCENT;
        setMonthlyRate();
    }

    public void setMonthlyRate() {
        this.monthlyRate = annualRate / MONTHS_IN_YEAR;
    }

    public void setPeriod(final byte years) {
        if(years <= 0) {
            throw new InstantiationError("Period cannot be zero or less.");
        }
        this.period = (short) (years * MONTHS_IN_YEAR);
    }

    public void setPaymentsMade(final short paymentsMade) {
        if(paymentsMade < 0 || paymentsMade > period) {
            throw new InstantiationError("Number of payments cannot be less than zero or more than the period.");
        }
        this.paymentsMade = paymentsMade;
    }

    public int getPrincipal() {
        return this.principal;
    }

    public float getMonthlyRate() {
        return this.monthlyRate;
    }

    public short getPeriod() {
        return this.period;
    }

    public short getPaymentsMade() {
        return this.paymentsMade;
    }

}