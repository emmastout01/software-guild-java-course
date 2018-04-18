
import static javax.swing.Spring.height;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class EqTriangle extends Shape {

    private final double baseLength;

    public EqTriangle(String color, double baseLength) {
        super(color);
        this.baseLength = baseLength;
    }

    
    
    @Override
    double getArea() {
        return (Math.pow(3, .5) * Math.pow(baseLength, 2)) / 4;
       
    }

    @Override
    double getPerimeter() {
        return 3 * baseLength;
  
    }
    
    
}
