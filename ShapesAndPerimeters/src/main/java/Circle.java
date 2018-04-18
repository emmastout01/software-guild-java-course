/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class Circle extends Shape {

    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    @Override
    double getArea() {
       return Math.PI * Math.pow(radius, 2);
    }

    @Override
    double getPerimeter() {
        return 2* Math.PI * radius;
    }
    
}
