
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
public class BackwardsEngineeringKylesProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String myName;
        String myNameReversed = "";
        
        System.out.println("Please enter your full name: ");
        myName = input.nextLine();
        
        for (int i = myName.length(); i >= 0; i--) {
            char currentChar = myName.charAt(i);
            myNameReversed += currentChar;
        }
        
        System.out.println(myNameReversed);
        
    }
}
