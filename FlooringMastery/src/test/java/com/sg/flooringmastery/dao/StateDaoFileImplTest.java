/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emmastout
 */
public class StateDaoFileImplTest {

    private StateDao dao = new StateDaoFileImpl();
    
    @Before
    public void setUp() {
        /*We assume that we're starting with a file that 
        has the following information:
        State,TaxRate
        OH,6.25
        PA,6.75
        MI,5.75
        IN,6.00
         */
    }

    /**
     * Test of getAllStates method, of class StateDaoFileImpl.
     */
    @Test
    public void testGetAllStates() throws Exception {
        assertEquals(4, dao.getAllStates().size());
    }

    /**
     * Test of getState method, of class StateDaoFileImpl.
     */
    @Test
    public void testGetState() throws Exception {
        
        assertEquals("MI", dao.getState("MI").getStateName());
        
        BigDecimal testTaxRate = new BigDecimal("6.25");
        
        assertEquals(testTaxRate, dao.getState("OH").getTaxRate());
    }

}
