/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class RegPolygon extends Shape {

    private final int numSides;
    private final double sideLength;

    public RegPolygon(String color, double sideLength, int numSides) {
        super(color);
        this.sideLength = sideLength;
        this.numSides = numSides;
    }
   
    @Override
    double getArea() {
        double apothem = this.sideLength/(2 * Math.tan(Math.PI/this.numSides));
        double perim = this.numSides * this.sideLength;
        return (apothem * perim) /2;
          }

    @Override
    double getPerimeter() {
        return this.numSides * this.sideLength;
    }
    
}
