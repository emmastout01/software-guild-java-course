/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Treat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 *
 * @author emmastout
 */
//@Component
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";
    private Map<Integer, Treat> treats = new HashMap<>();

    @Override
    public List<Treat> getTreats() throws VendingMachinePersistenceException {
        readInventory();
        return new ArrayList<Treat>(treats.values());
    }

    @Override
    public Treat getMyTreat(int treatId) throws VendingMachinePersistenceException {
        readInventory();
        Treat myTreat = treats.get(treatId);
        return myTreat;
    
    }

    @Override
    public Treat updateTreat(int treatId) throws VendingMachinePersistenceException {
        //Here we want to decrease the inventory by 1. We don't want to remove the whole treat so I need to think about how to do that.
        readInventory();
        Treat myTreat = treats.get(treatId);
        int currentInventory = myTreat.getInventory();
        myTreat.setInventory(currentInventory - 1);
        updateInventory();
        return myTreat; 
    }

    private void updateInventory() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save inventory data.", e);
        }

        List<Treat> treatList = this.getTreats();

        for (Treat currentTreat : treatList) {
            out.println(currentTreat.getTreatId() + DELIMITER
                    + currentTreat.getName() + DELIMITER
                    + currentTreat.getCost() + DELIMITER
                    + currentTreat.getInventory());
            out.flush();
        }
        out.close();
    }

    private void readInventory() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "Could not load inventory data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;

        String[] currentTokens;
        // Go through INVENTORY_FILE line by line, decoding each line into a 
        // Treat object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);

            int treatId = Integer.parseInt(currentTokens[0]);
            Treat currentTreat = new Treat(treatId);
            currentTreat.setName(currentTokens[1]);
            BigDecimal treatCost = new BigDecimal(currentTokens[2]);
            int treatInventory = Integer.parseInt(currentTokens[3]);
            currentTreat.setCost(treatCost);
            currentTreat.setInventory(treatInventory);

            // Put currentTreat into the map using treat name as the key
            treats.put(currentTreat.getTreatId(), currentTreat);
        }
        // close scanner
        scanner.close();
    }

}
