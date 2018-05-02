
import java.time.LocalDate;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class LetsLearnCircles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radiusIn;
        double diameter;
        double circumference;
        double area;
        
        
        System.out.println("Give me a circle's radius, and I'll tell you"
                + " some stuff about it!");
        System.out.println("=================");
        System.out.println("Radius: ");
        
        radiusIn = input.nextDouble();
        
        diameter = radiusIn * 2;
        circumference = Math.PI * 2 * radiusIn;
        area = Math.PI * Math.pow(radiusIn, 2);
        
        System.out.println("Radius: " + radiusIn);
        System.out.println("Diameter: " + diameter);
        System.out.println("Circumference: " + circumference);
        System.out.println("Area: " + area);    
        
        System.out.println("LOCAL DATE: " + LocalDate.now());
    }
}
