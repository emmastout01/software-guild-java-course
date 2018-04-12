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
import java.util.Random;

public class DogGenetics {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Random rand = new Random();
        
        String dogName;
        int percentGermanShep;
        int percentPortWaterDog;
        int percentGreatDane;
        int percentBorderCollie;
        int percentScottie;
        int percentUsedUp = 0;
        
        //Ask user for dog's name
        System.out.println("What is your loveable pooch's name?");
        dogName = inputReader.nextLine();
        
        //Randomly assign percentage to 5 dog breeds
         
        percentGermanShep = rand.nextInt(100) + 1;
        percentUsedUp += percentGermanShep;
        percentPortWaterDog = rand.nextInt(100 - percentUsedUp) + 1;
        percentUsedUp += percentPortWaterDog;
        percentGreatDane = rand.nextInt(100 - percentUsedUp) + 1;
        percentUsedUp += percentGreatDane;
        percentBorderCollie = rand.nextInt(100 - percentUsedUp) + 1;
        percentUsedUp += percentBorderCollie;
        percentScottie = rand.nextInt(100 - percentUsedUp) + 1;
        percentUsedUp += percentScottie;
        
        //Print dog's 'pedigree' to console
        System.out.println("Here's " + dogName + "'s pedigree!");
        System.out.println("");
        System.out.println(percentGermanShep + "% German Shephard");
        System.out.println(percentPortWaterDog + "% Portugese Water Dog");
        System.out.println(percentGreatDane + "% Great Dane");
        System.out.println(percentBorderCollie + "% Border Collie");
        System.out.println(percentScottie + "% Scottish Terrier");
        
        System.out.println("");
        System.out.println("Wow, that's QUITE a dog!");
                
    }
}
