/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class ConsoleIO {

    private Scanner input = new Scanner(System.in);

    public void print(String input) {
        System.out.println(input);
    }

    public void printf(String input, String args) {
        System.out.printf(input, args);
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    public int readInt(String prompt) {
        boolean isValid = false;
        int result = 0;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = Integer.parseInt(value);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number. \n", value);
            }
        } while (!isValid);
        return result;
    }

    // Prompt the user to enter a number between the minimum and maximum value
    public int readInt(String prompt, int min, int max) {
        boolean isValid = false;
        int result = 0;
        do {
            result = readInt(prompt);
            if (result >= min && result <= max) {
                isValid = true;
            } else {
                System.out.printf("The value must be between %s and %s. \n", min, max);
            }
        } while (!isValid);
        return result;
    }

    public String readStringPrintf(String prompt, String args) {
        System.out.printf(prompt, args);
        return input.nextLine();
    }

    public BigDecimal readBigDecimalPrintf(String prompt, String args) {
        BigDecimal result;
        String userInput = readStringPrintf(prompt, args);
        result = readBigDecimalFromString(userInput, 0);
        return result;
    }

    public BigDecimal readBigDecimalFromString(String prompt) {
        boolean isValid = false;
        BigDecimal result = BigDecimal.ZERO;

        do {
            String value = null;
            try {
                value = readString(prompt);
                result = new BigDecimal(value);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number. \n", value);
            }
        } while (!isValid);
        return result;
    }

    public BigDecimal readBigDecimalFromString(String prompt, int minimum) {
        boolean isValid = false;
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal min = new BigDecimal(minimum);

        do {
            result = readBigDecimalFromString(prompt);
            if ((result.compareTo(min) == 1 || result.compareTo(min) == 0)) {
                isValid = true;
            } else {
                System.out.printf("The value must be greater than 0.");
            }
        } while (!isValid);
        return result;
    }

    public String readStringOrDefault(String prompt, String args, String defaultMessage) {
        String result = readStringPrintf(prompt, args);
        if (!result.isEmpty()) {
            return result;
        } else {
            return defaultMessage;
        }
    }

    public LocalDate readLocalDateFromString(String prompt) {
        boolean isValid = false;
        LocalDate date = LocalDate.now();

        do {
            //Here, I want to take a user's string of 

        } while (!isValid);
        return date;
    }

    BigDecimal validateBigDecimal(String userInput) {
        boolean isValid = false;
        BigDecimal result = BigDecimal.ZERO;

//        do {
            try {
                result = new BigDecimal(userInput);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number. \n", userInput);
            }

//        } while (!isValid);
        return result;
    }

    BigDecimal validateBigDecimal(String userInput, int minimum) {
        boolean isValid = false;
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal min = new BigDecimal(minimum);

//        do {
            result = validateBigDecimal(userInput);
            if ((result.compareTo(min) == 1 || result.compareTo(min) == 0)) {
                isValid = true;
            } else {
                System.out.printf("The value must be greater than 0.");
                
            }
//        } while (!isValid);
        return result;
    }

}
