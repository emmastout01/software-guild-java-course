/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.aliceinwonderland;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class App {
    
    public static void main(String[] args) {
        
        
        FileReader read = new FileReader();
        
        List<String> list = read.loadRoster();
         String alice = "Alice";
         int numAlices = 0;

        for (String word : list) {
            if (word.equals(alice) || word.equals("Alice,") || word.equals("Alice.") || word.equals("Alice;") || word.equals("Alice!")) {
                numAlices++;
            }
        }
        
        System.out.println("Alices: " + numAlices);
    }
    
}
