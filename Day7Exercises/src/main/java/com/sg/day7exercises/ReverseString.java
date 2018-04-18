/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.day7exercises;

/**
 *
 * @author emmastout
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println("testing '': " + reverse(""));
        System.out.println("testing 'abcde': " + reverse("abcde"));
        System.out.println("testing 'bagel': " + reverse("bagel"));
        System.out.println("testing null: " + reverse(null));
        System.out.println("testing 'bird': " + reverse("bird"));
        System.out.println("testing 'a but tuba': " + isPalindrome("a but tuba"));
        System.out.println("testing 'kayak': " + isPalindrome("kayak"));
        System.out.println("testing 'nancy': " + isPalindrome("nancy"));
        System.out.println("testing 'no lemon, no melon': " + isPalindrome("no lemon, no melon"));
        System.out.println("testing 'red rum, sir, is murder': " + 
                isPalindrome("red rum, sir, is murder"));
        System.out.println("testing 'dammit, i'm mad!: " 
                + isPalindrome("dammit, i'm mad!"));
        
    }

    public static String reverse(String input) {
        String result = "";
        if (input == null) {
            return null;
        } else if (input.equals("")) {
            return "";
        } else {
            for (int i = input.length() - 1; i >= 0; i--) {
                result += input.charAt(i);
            }
            return result;
        }
    }

    public static boolean isPalindrome(String input) {
        String result = "";
        String modifiedInput = "";

        if (input == null) {
            System.out.println("user entered null.");
            return true;
        } else if (input.equals("")) {
            System.out.println("user entered empty string.");
            return true;
        } else {
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (Character.isLetter(currentChar)) {
                    modifiedInput += input.charAt(i);
                }
            }

            for (int i = input.length() - 1; i >= 0; i--) {
                char currentChar = input.charAt(i);
                if (Character.isLetter(currentChar)) {
                    result += input.charAt(i);
                }
            }
            return result.equals(modifiedInput);
        }
    }

}
