/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.State;
import java.util.List;

/**
 *
 * @author emmastout
 */
public interface StateDao {
     public List<State> getAllStates()
             throws FlooringMasteryPersistenceException;

    public State getState(String stateName)
            throws FlooringMasteryPersistenceException;

}
