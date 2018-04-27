/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Treat;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author emmastout
 */
public interface VendingMachineService {

    public Change purchaseTreat(BigDecimal addedMoney, int myTreat)
            throws VendingMachinePersistenceException,
            InsufficientFundsException,
            OutOfStockException;
    
    public List<Treat> getTreats() throws VendingMachinePersistenceException;
    
}



