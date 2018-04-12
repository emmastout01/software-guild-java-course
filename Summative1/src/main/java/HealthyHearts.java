/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int userAge;
        int maxHeartRate;
        long minHRZone;
        long maxHRZone;
             

        //Ask user for age
        System.out.println("Let's calculate your target heart rate!");
        System.out.println("");
        System.out.println("What is your age?");
        userAge = inputReader.nextInt();
        
        //Calculate max heart rate
        maxHeartRate = 220 - userAge;
        
        //Calculate target heart rate zone
        minHRZone = Math.round(.5 * maxHeartRate);
        maxHRZone = Math.round(.85 * maxHeartRate);
        
        //Print max heart rate and target HR zone
        System.out.println("Your maximum heart rate should be " + maxHeartRate + 
                " beats per minute.");
        System.out.println("Your target heart rate zone is " + minHRZone +
                " - " + maxHRZone + " beats per minute.");
    }
}
