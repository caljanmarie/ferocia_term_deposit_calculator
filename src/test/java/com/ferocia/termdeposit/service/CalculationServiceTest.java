package com.ferocia.termdeposit.service;

import com.ferocia.termdeposit.constants.InterestFrequency;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;

public class CalculationServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("Calculate returns at maturity")
    public void testCalculateAtMaturity() {
        BigDecimal finalBalance = calculatorService.calculateFinalBalance(BigDecimal.valueOf(10000), BigDecimal.valueOf(1.1), 3, InterestFrequency.MA);
        assert(finalBalance.compareTo(BigDecimal.valueOf(10330)) == 0);

        finalBalance = calculatorService.calculateFinalBalance(BigDecimal.valueOf(100000), BigDecimal.valueOf(2.1), 5, InterestFrequency.MA);
        assert(finalBalance.compareTo(BigDecimal.valueOf(110500)) == 0);
    }

    @Test
    @DisplayName("Calculate returns - monthly interest")
    public void testCalculateReturnsMonthlyInterest() {
        BigDecimal finalBalance = calculatorService.calculateFinalBalance(BigDecimal.valueOf(10000), BigDecimal.valueOf(1.1), 3, InterestFrequency.MO);
        assert(finalBalance.compareTo(BigDecimal.valueOf(10335)) == 0);

        finalBalance = calculatorService.calculateFinalBalance(BigDecimal.valueOf(100000), BigDecimal.valueOf(2.1), 5, InterestFrequency.MO);
        assert(finalBalance.compareTo(BigDecimal.valueOf(111061)) == 0);
    }

    @Test
    @DisplayName("Calculate returns - quarterly interest")
    public void testCalculateReturnsQuarterlyInterest() {
        BigDecimal finalBalance = calculatorService.calculateFinalBalance(BigDecimal.valueOf(10000), BigDecimal.valueOf(1.1), 3, InterestFrequency.Q);
        assert(finalBalance.compareTo(BigDecimal.valueOf(10335)) == 0);

        finalBalance = calculatorService.calculateFinalBalance(BigDecimal.valueOf(100000), BigDecimal.valueOf(2.1), 5, InterestFrequency.Q);
        assert(finalBalance.compareTo(BigDecimal.valueOf(111041)) == 0);
    }

    @Test
    @DisplayName("Calculate returns - annual interest")
    public void testCalculateReturnsAnnualInterest() {
        BigDecimal finalBalance = calculatorService.calculateFinalBalance(BigDecimal.valueOf(10000), BigDecimal.valueOf(1.1), 3, InterestFrequency.A);
        assert(finalBalance.compareTo(BigDecimal.valueOf(10334)) == 0);

        finalBalance = calculatorService.calculateFinalBalance(BigDecimal.valueOf(100000), BigDecimal.valueOf(2.1), 5, InterestFrequency.A);
        assert(finalBalance.compareTo(BigDecimal.valueOf(110950)) == 0);
    }


}
