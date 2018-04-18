/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arraylistmappingexercises.StateCapitals2;

import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */

public class StateCapitals2 {
    public static void main(String[] args) {
         HashMap<String, Capital> stateCapitals = new HashMap<>();
         Scanner inputReader = new Scanner(System.in);

        stateCapitals.put("Alabama", new Capital("Montgomery", 35999, 794.3));
        stateCapitals.put("Alaska", new Capital("Juneau", 400352, 837.8));
        stateCapitals.put("Arizona", new Capital("Phoenix", 739299, 5774.9));
        stateCapitals.put("Arkansas", new Capital("Little Rock", 8374774, 988.3));
        stateCapitals.put("California", new Capital("Sacramento", 585853, 9838.9));
        stateCapitals.put("Colorado", new Capital("Denver", 4848484, 9998.7));
       
        Set<String> states = stateCapitals.keySet();
        
        System.out.println("Please enter the lower limit for a city population: ");
        int lowerLimit = inputReader.nextInt();
        
        System.out.println("Listing capitals with populations "
                + "greater than " + lowerLimit + ": ");
        for(String state : states) {
            Capital capital = stateCapitals.get(state);
            String name = capital.getName();
            int pop = capital.getPopulation();
            double sqMiles = capital.getSqMileage();
            
            if(pop >= lowerLimit) {
               System.out.println(state 
                    + " - "+ name
                    + " | Population: " + pop
                    + " | Square Mileage: " + sqMiles); 
            }   
        }
        
        
        
    }
 
           
    
}
