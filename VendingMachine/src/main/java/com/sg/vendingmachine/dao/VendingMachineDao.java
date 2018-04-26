/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Treat;
import java.util.List;

/**
 *
 * @author emmastout
 */
public interface VendingMachineDao {
    
    //Get list of all treats
    public List<Treat> getTreats()
            throws VendingMachinePersistenceException;
    
    //Get one treat type
    public Treat getMyTreat(String treatName)
            throws VendingMachinePersistenceException;
    
    //Decrease treat inventory by one
    public Treat updateTreat(String treatName) 
            throws VendingMachinePersistenceException;
}
