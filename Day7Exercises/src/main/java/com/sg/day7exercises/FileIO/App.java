/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.day7exercises.FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/**
 *
 * @author emmastout
 */
public class App {
    public static void main(String[] args) {
        //This is a different way to read lines
        //Paths is a class that helps 
        Path p = Paths.get("fruits.txt");
        try {
            //This only works if the file is converted from String file name to 
            //a path. 
            List<String> lines = Files.readAllLines(p);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
    
    public static void write() {
        try {
            //This file will be created in the root directory--
            //the path here is relative to the file directory.
            PrintWriter writer = new PrintWriter
                //Here, the 'true' means we want to append the file 
                //instead of truncating. 
                //here are multiple constructions for filewriter available 
                //that each do different things.
                (new FileWriter("fruits.txt", true));
            writer.write("apples\n");
            writer.write("mangos\n");
            writer.write("grapes\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
    private static void read() {
        try {
           //Maintains a memory buffer. Reads file blocks off the OS
           BufferedReader reader = new BufferedReader(
                   new FileReader("fruits.txt"));
           String line = null;
           //While there is another line to read, print out the lines
           while((line = reader.readLine()) !=null) {
               System.out.println(line);
           }
       } catch (IOException ex){
           System.out.println("Error: " + ex);
       }
    }
 
}
