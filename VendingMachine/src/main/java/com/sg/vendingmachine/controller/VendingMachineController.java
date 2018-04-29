/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Treat;
import com.sg.vendingmachine.service.Change;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.OutOfStockException;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineDao dao;
    private VendingMachineService service;

    public VendingMachineController(VendingMachineView view,
            VendingMachineDao dao, VendingMachineService service) {
        this.view = view;
        this.dao = dao;
        this.service = service;
    }

    public void run()
            throws VendingMachinePersistenceException {
        boolean isRunning = true;

        try {
            while (isRunning) {
                //Display all treats
                List<Treat> treatList = service.getTreats();
                view.displayTreats(treatList);
                
                //Display menu and get user selection
                int menuChoice = view.displayMenuAndGetSelection();

                switch (menuChoice) {
                    case 1:
                        purchaseTreat();
                        break;
                    case 0:
                        isRunning = false;
                        break;
                }
            }
            view.displayExitMessage();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    public void purchaseTreat()
            throws VendingMachinePersistenceException {
        boolean hasErrors = false;

        do {
            //Prompt user to add money
            BigDecimal addedMoney = view.addMoney();
            //Prompt user to select a treat to buy
            int myTreatId = view.chooseTreat();
            //Send the treat selection + money amt to service for validation check
            try {
                Change changeToReturn = service.purchaseTreat(addedMoney, myTreatId);
                returnChange(changeToReturn);
                hasErrors = false;
            } catch (InsufficientFundsException | OutOfStockException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
        
        //On the service/dao side: If it's valid, decrease inventory by 1
        //Get back change from the service and send this along to the view to display
    }
    
    public void returnChange(Change change) {
        int quarters = change.getQuarters();
        int dimes = change.getDimes();
        int nickels = change.getNickels();
        int pennies = change.getPennies();
        
        view.displayChange(quarters, dimes, nickels, pennies);
    }

}
