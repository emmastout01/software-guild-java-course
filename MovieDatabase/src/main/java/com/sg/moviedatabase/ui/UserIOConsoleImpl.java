/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.ui;

import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class UserIOConsoleImpl implements UserIO {
    private Scanner input = new Scanner(System.in);

   
    @Override
    public void print(String input) {
        System.out.println(input);
    }
    
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    @Override
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
 
    @Override
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

    @Override
    public String readStringPrintf(String prompt, String args) {
        System.out.printf(prompt, args);
         return input.nextLine();     
    }

}
