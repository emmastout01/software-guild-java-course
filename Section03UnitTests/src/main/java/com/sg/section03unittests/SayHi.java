/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author emmastout
 */
public class SayHi {
        // Given a String name, e.g. "Bob", return a greeting of the 
    // form "Hello Bob!". 
    //
    // sayHi("Bob") -> "Hello Bob!"
    // sayHi("Alice") -> "Hello Alice!"
    // sayHi("X") -> "Hello X!"
    public String sayHi(String name) {
        String hello = "Hello " + name + "!";
        return hello;
    }

}
