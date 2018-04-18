/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public abstract class Shape {
    private String color;
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
     
    public Shape(String color) {
        this.color = color;
    }
    
    abstract double getArea();
    abstract double getPerimeter();
}
