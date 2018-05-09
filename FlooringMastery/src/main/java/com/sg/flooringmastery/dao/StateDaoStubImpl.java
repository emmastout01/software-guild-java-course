/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.State;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emmastout
 */
public class StateDaoStubImpl implements StateDao {

        private Map<String, State> stateList = new HashMap<>();
    
    public StateDaoStubImpl() {
        
        BigDecimal tax = new BigDecimal("5");
        
        State state1 = new State("MN");
        State state2 = new State("OH");
       
        state1.setTaxRate(tax);
        state2.setTaxRate(tax);
        
        stateList.put(state1.getStateName(), state1);
        stateList.put(state2.getStateName(), state2);
    }
    
    @Override
    public List<State> getAllStates() throws FlooringMasteryPersistenceException {
       return new ArrayList<>(stateList.values());
    }

    @Override
    public State getState(String stateName) throws FlooringMasteryPersistenceException {
        return stateList.get(stateName);
    }
    
}
