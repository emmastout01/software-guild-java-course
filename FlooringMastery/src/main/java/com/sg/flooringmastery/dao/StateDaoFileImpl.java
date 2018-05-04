/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class StateDaoFileImpl implements StateDao {

    public static final String DELIMITER = "::";
    public static final String PRODUCT_LIST = "states.txt";
    private Map<String, State> stateList = new HashMap<>();

    @Override
    public List<State> getAllStates()  
            throws FlooringMasteryPersistenceException{
        loadStates();
        return new ArrayList<>(stateList.values());
    }

    @Override
    public State getState(String stateName) 
            throws FlooringMasteryPersistenceException{
        loadStates();
        return stateList.get(stateName);
    }

    private void loadStates() throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCT_LIST)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "Could not load product list.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            State currentState = new State(currentTokens[0]);

            BigDecimal taxRate = new BigDecimal(currentTokens[1]);

            currentState.setTaxRate(taxRate);

            stateList.put(currentState.getStateName(), currentState);
        }
        scanner.close();
    }
}
