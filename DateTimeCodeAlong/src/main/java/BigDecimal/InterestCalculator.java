/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BigDecimal;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class InterestCalculator {
     public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        BigDecimal initialPrincipal;
        BigDecimal annualInterestRate;
        int yearsAccrued;
        BigDecimal yearStartTotal;
        BigDecimal annualInterest;
        BigDecimal yearEndTotal;
        int currentYear =0;
        String compoundPeriod;
       
        System.out.println("How much money are you investing?");
         String initialPrincipalString = inputReader.nextLine();
         initialPrincipal = new BigDecimal(initialPrincipalString);
        
        System.out.println("What's your interest rate?");
        String annualInterestRateString = inputReader.nextLine();
        annualInterestRate = new BigDecimal(annualInterestRateString);
        
        System.out.println("How many years will it stay in the fund?");
        yearsAccrued = inputReader.nextInt();
        inputReader.nextLine();
        
        System.out.println("How do you want to compound interest? "
                + "Options are quarterly (type 'Q'), monthly (type 'M'), "
                + "or daily (type 'D').");
        compoundPeriod = inputReader.nextLine();
       
        for (int i = 0; i < yearsAccrued; i++) {
            System.out.println("Current Year: " + currentYear);
            yearStartTotal = initialPrincipal;
            
           if (compoundPeriod.equals("Q")){
              for (int j = 0; j < 4; j++) {
                initialPrincipal = returnNewBalance(initialPrincipal, 
                    annualInterestRate, compoundPeriod);
            } 
           } else if (compoundPeriod.equals("M")){
              for (int j = 0; j < 12; j++) {
                initialPrincipal = returnNewBalance(initialPrincipal, 
                    annualInterestRate, compoundPeriod);
            } 
           }
              if (compoundPeriod.equals("D")){
              for (int j = 0; j < 365; j++) {
                initialPrincipal = returnNewBalance(initialPrincipal, 
                    annualInterestRate, compoundPeriod);
            } 
           }
            
            yearEndTotal = initialPrincipal;
            annualInterest = yearEndTotal.subtract(yearStartTotal);
 
            String annIntStr = df.format(annualInterest);
            String yrStartStr = df.format(yearStartTotal);
            String yrEndStr = df.format(yearEndTotal); 
            
            System.out.println("Principal at beginning of year: $" + yrStartStr);
            System.out.println("Interest earned: $" + annIntStr);
            System.out.println("Principal at end of year: $" + yrEndStr);
                
            currentYear++;        
        }
    }
    
    public static BigDecimal returnNewBalance(BigDecimal currentBalance, 
            BigDecimal annualInterestRate, String compoundPeriod) {
        BigDecimal interestRate = annualInterestRate;
        if(compoundPeriod.equals("Q")){
            BigDecimal quarter = new BigDecimal("4");
            interestRate = annualInterestRate.divide(quarter, 2, HALF_UP);
        } else if (compoundPeriod.equals("M")) {
            BigDecimal month = new BigDecimal("12");
            interestRate = annualInterestRate.divide(month, 2, HALF_UP);
        } else if (compoundPeriod.equals("D")) {
            BigDecimal day = new BigDecimal("365");
            interestRate = annualInterestRate.divide(day, 2, HALF_UP);
        }
        
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal interestRatePercent = interestRate.divide(hundred);
        BigDecimal one = new BigDecimal("1");
        BigDecimal multipland = interestRatePercent.add(one);
        
 
        BigDecimal newBalance = currentBalance.multiply(multipland);
       return newBalance;
    }
}

