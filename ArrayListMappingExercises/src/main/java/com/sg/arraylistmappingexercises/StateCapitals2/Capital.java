/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arraylistmappingexercises.StateCapitals2;

/**
 *
 * @author emmastout
 */
public class Capital {
    private String name;
    private int population;
    private double sqMileage;
    
    public Capital(String name, int pop, double sqMiles) {
        this.name = name;
        this.population = pop;
        this.sqMileage = sqMiles;
    }
    
    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return population;
    }

    public double getSqMileage() {
        return sqMileage;
    }
   
}
