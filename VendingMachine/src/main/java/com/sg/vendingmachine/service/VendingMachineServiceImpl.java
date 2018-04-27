/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Treat;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author emmastout
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;
    private BigDecimal moneyInMachine;

    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public Change purchaseTreat(BigDecimal addedMoney, int myTreatId) throws
            VendingMachinePersistenceException,
            InsufficientFundsException,
            OutOfStockException {

        BigDecimal startingChange = new BigDecimal("0");
        Change changeToReturn = new Change(startingChange);
       
        //Get the treat in question
        
        Treat myTreat = dao.getMyTreat(myTreatId);
        //Validate the purchase
        boolean isValid = isPurchaseValid(addedMoney, myTreat);

        //If purchase is valid, then call updateTreat()
        if (isValid) {
            dao.updateTreat(myTreatId);
            BigDecimal change = addedMoney.subtract(myTreat.getCost());
            changeToReturn = new Change(change);
        }
        
        return changeToReturn;
        
    }
    
    private boolean isPurchaseValid(BigDecimal addedMoney, Treat myTreat) throws
            VendingMachinePersistenceException,
            InsufficientFundsException,
            OutOfStockException {

        //If user has insufficient funds throw an insufficient funds error
        BigDecimal myTreatCost = myTreat.getCost();
        int myTreatInventory = myTreat.getInventory();
        moneyInMachine = addedMoney;

        if(addedMoney.compareTo(myTreatCost) >= 0 && myTreatInventory > 0) {
            return true;
        }
        
        if (addedMoney.compareTo(myTreatCost) == -1) {
            throw new InsufficientFundsException(
                    "Error: You have not added enough money to purchase this item.");
        }
        //If user tries to buy something out of stock, throw out of stock error      
        if (myTreatInventory <= 0) {
            throw new OutOfStockException(
                    "Error: We're all out of that treat.");
        } 
        moneyInMachine = BigDecimal.ZERO;
        return false;
    }

    @Override
    public List<Treat> getTreats() throws VendingMachinePersistenceException {
        return dao.getTreats().stream()
                .filter(treat -> treat.getInventory() > 0)
                .collect(Collectors.toList());
    }

}
