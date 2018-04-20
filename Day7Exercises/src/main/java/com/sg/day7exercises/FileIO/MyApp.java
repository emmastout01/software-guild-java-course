/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.day7exercises.FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emmastout
 */
public class MyApp {
    public static void main(String[] args) {
      write();  
      read();
    }
    
    public static void write() {
        try {
            PrintWriter writer = new PrintWriter("students.txt");
            writer.println("Nancy");
            writer.println("Emma");
            writer.println("Amanda");
            writer.println("Greg");
            writer.println("Blair");
            writer.println("Natalie");
            writer.println("Nick");
            writer.println("Mark");
            writer.println("Kyle");
            writer.println("Sam");
            writer.println("Peter");
            writer.println("Kyle");
            writer.println("Corbin");   
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
    public static void read() {
        try {
            Scanner sc = new Scanner(new BufferedReader
                        (new FileReader("students.txt")));
            while(sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                System.out.println(currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
}
