/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.ui;

/**
 *
 * @author emmastout
 */
public interface UserIO {

    void print(String input);
    
    String readStringPrintf(String prompt, String args);

    int readInt(String prompt);

    // Prompt the user to enter a number between the minimum and maximum value
    int readInt(String prompt, int min, int max);

    String readString(String prompt);
    
}
