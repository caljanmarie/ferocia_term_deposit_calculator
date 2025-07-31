package com.ferocia.termdeposit;

import com.ferocia.termdeposit.constants.InterestFrequency;
import com.ferocia.termdeposit.service.CalculatorService;
import com.ferocia.termdeposit.service.InputService;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.ferocia.termdeposit.constants.InputConstraints.numberFormat;

public class TermDepositCalculator {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        CalculatorService calculatorService = new CalculatorService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------Term Deposit Calculator----------------");
            BigDecimal amount = inputService.promptForAmount();
            BigDecimal interestRate = inputService.promptForInterest();
            int termInYears = inputService.promptForTerm();
            InterestFrequency interestFrequency = inputService.promptForInterestFrequency();

            BigDecimal finalBalance = calculatorService.calculateFinalBalance(amount, interestRate, termInYears, interestFrequency);

            String formattedBalance = numberFormat.format(finalBalance);
            System.out.println("Final Balance after " + termInYears + "years: " + formattedBalance);

            System.out.println("Do you want to perform another calculation? [Y/N]");
            String answer = scanner.nextLine().trim();

            if(!answer.equalsIgnoreCase("Y")) {
                System.out.println("Thank you for using the calculator.");
                break;
            }
        }

        scanner.close();

    }
}