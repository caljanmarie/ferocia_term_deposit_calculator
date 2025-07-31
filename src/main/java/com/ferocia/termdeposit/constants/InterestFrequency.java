package com.ferocia.termdeposit.constants;

public enum InterestFrequency {
    MO(12),
    Q(4),
    A(1),
    MA(1); // not compounding

    private final int compoundingPerYear;

    InterestFrequency(int compoundingPerYear) {
        this.compoundingPerYear = compoundingPerYear;
    }

    public int getCompoundingPerYear() {
        return compoundingPerYear;
    }

    public boolean isCompounded() {
        return this != MA;
    }
}
