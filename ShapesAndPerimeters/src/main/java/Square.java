/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class Square extends Shape {

    private final double sideLength;
    
    public Square(String color, double sideLength) {
        super(color);
        this.sideLength = sideLength;
    }
    
    // Here, we want to return Area and Perimeter. We don't want to store 
    // these things as state. 
    @Override
    double getArea() {
       return sideLength * sideLength;
    }

    @Override
    double getPerimeter() {
        return sideLength * 4;
    }
    
}
