/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Treat;
import com.sg.vendingmachine.service.Change;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class VendingMachineView {
    private ConsoleIO io = new ConsoleIO();
    
    
    public void displayTreats(List<Treat> treatList) {
        io.print("VENDING MACHINE TREATS");
        io.print("==============");
        for(Treat treat : treatList) {
            io.print(treat.getName());
            io.print("Treat ID: " + treat.getTreatId());
            io.print("Cost: " + treat.getCost());
            io.print("Inventory Count: " + treat.getInventory());
            io.print("");
        }
    }
    
    public int displayMenuAndGetSelection() {
        io.print("Press '1' to insert money and make a treat selection.");
        io.print("Press '0' to exit the Vending Machine.");

        return io.readInt("Your selection: ", 0, 1);
    }
    
    public BigDecimal addMoney() {
         BigDecimal moneyAdded = io.readBigDecimalFromString
            ("Please insert your money: ");
         return moneyAdded;
    }
    
    //This function will need some work
    public int chooseTreat() {
       int treatSelection = io.readInt("Please make a treat ID selection: ");
       return treatSelection;
    }
    
    public void displayChange(int quarters, int dimes, int nickels, int pennies) {
        io.print("Your purchase was successsful. Here's your change!");
        io.print(quarters + " quarters, " 
                    + dimes + " dimes, "
                    + nickels + " nickels, and " 
                    + pennies + " pennies.");
        io.print("");
    }
    
    public void displayError() {
        io.print("Error");
    }
    
    public void displayExitMessage() {
        io.print("Thank you! Goodbye.");
    }
    
     public void displayErrorMessage(String message) {
        io.print(message);
    }
}
