/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.day7exercises.FileIO;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emmastout
 */
public class App {
    public static void main(String[] args) {
        try {
            //This file will be created in the root directory--
            //the path here is relative to the file directory.
            PrintWriter writer = new PrintWriter
                (new FileWriter("fruits.txt", true));
            writer.write("apples\n");
            writer.write("mangos\n");
            writer.write("grapes\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
 
}
