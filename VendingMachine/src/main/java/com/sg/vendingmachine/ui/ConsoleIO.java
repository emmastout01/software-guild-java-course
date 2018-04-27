/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.math.BigDecimal;
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
                System.out.printf("The value '%s' is not a number. \n", ex);
            }
        } while (!isValid);
        return result;
    }

}
