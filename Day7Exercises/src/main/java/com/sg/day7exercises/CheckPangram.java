/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.day7exercises;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class CheckPangram {

    public static void main(String[] args) {
        isPangram("Bawds jog, flick quartz, vex nymph.");
        isPangram("Fox nymphs grab quick-jived waltz.");
        isPangram("stoehunatehtiaoehsaoeuhanoetuhnasoeuhtaoseuaeotuhaesutsaehous");
        isPangram("Pack my box with five dozen liquor jugs.");
        isPangram("sntoheusoeutn");
        
    }

    public static boolean isPangram(String string) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        String myString = string.toLowerCase();
        
        List<Character> words = new ArrayList<>();

        if (myString.length() >= 26) {
            for (int i = 0; i < myString.length(); i++) {
                for (int j = 0; j < letters.length; j++) {
                    if (myString.charAt(i) == letters[j] && !words.contains(letters[j])) {

                        words.add(letters[j]);

                        if (words.size() == 26) {
                            System.out.println(string + " is a pangram.");
                            return true;
                        }

                    }
                }
            }
        }
        if (words.size() != 26) {
            System.out.println(string + " is not a pangram!");
        }
        return false;
    }
}
