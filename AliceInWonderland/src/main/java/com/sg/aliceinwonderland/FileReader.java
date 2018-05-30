/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.aliceinwonderland;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class FileReader {
    
   public List<String> aliceList = new ArrayList<>();
    
    public List<String> loadRoster()  {
        Scanner scanner = null;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new java.io.FileReader("alice-in-wonderland.txt")));
        } catch (FileNotFoundException e) {
        }
        // currentLine holds the most recent line read from the file
        String currentLine;

        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(" ");
            
            for (String word: currentTokens) {
                aliceList.add(word);
            }

         }
        scanner.close();
    
        return aliceList;
    }   
}
