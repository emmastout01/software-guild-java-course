/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Treat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Treat treat1 = new Treat(1);
    Treat treat2 = new Treat(2);
    Treat treat3 = new Treat(3);
    
    List<Treat> treatList = new ArrayList<>();

    private List<Treat> generateTreatList() {

        treat1.setName("100 Grand");
        treat1.setCost(BigDecimal.ONE);
        treat1.setInventory(3);

        treat2.setName("Milky Way");
        treat2.setCost(BigDecimal.TEN);
        treat2.setInventory(5);

        treat3.setName("Skittles");
        treat3.setCost(BigDecimal.TEN);
        treat3.setInventory(0);
        
        treatList.add(treat1);
        treatList.add(treat2);
        treatList.add(treat3);  
        
        return treatList;
    }

    @Override
    public List<Treat> getTreats() throws VendingMachinePersistenceException {
        generateTreatList();
        return treatList;
    }

    @Override
    public Treat getMyTreat(int treatId) throws VendingMachinePersistenceException {
        generateTreatList();
        //Set up so that we're getting the treat with the incoming treat id
        switch(treatId) {
            case 1: 
                return treat1;
            case 2:
                return treat2;
            case 3:
                return treat3;
            default: 
                return null;
        }
    }

    @Override
    public Treat updateTreat(int treatId) throws VendingMachinePersistenceException {
        generateTreatList();
           switch(treatId) {
            case 1: 
                return treat1;
            case 2:
                return treat2;
            case 3:
                return treat3;
            default: 
                return null;
        }
    }

}
