/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class App {
    public static void main(String[] args) {
        Shape purpleSquare = new Square("purple", 5.3);
//        printShape(purpleSquare);
        Shape redCircle = new Circle("red", 10);
//        printShape(redCircle);
        Shape yellowTriangle = new EqTriangle("yellow", 5);
//        printShape(yellowTriangle);
        RegPolygon newPolygon = new RegPolygon("red", 4, 4);
        printShape(newPolygon);
        RegPolygon dodecagon = new RegPolygon("turquoise", 5, 12);
        printShape(dodecagon);
    }
    
    public static void printShape(Shape shapeIn) {
        System.out.println("Color: " + shapeIn.getColor());
        System.out.println("Area: " + shapeIn.getArea());
        System.out.println("Perimeter: " + shapeIn.getPerimeter());
        System.out.println("");
    }
    
}
