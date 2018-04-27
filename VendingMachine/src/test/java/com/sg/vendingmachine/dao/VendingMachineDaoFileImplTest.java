/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Treat;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emmastout
 */
public class VendingMachineDaoFileImplTest {

    private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp()
            throws Exception {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTreats method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testGetTreats() throws Exception {
    

//Run getTreats
        //Assert that both treats are in the getTreats file
    }

    /**
     * Test of getMyTreat method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testGetMyTreat() throws Exception {
        //Run getMyTreat on the first treat

        //assert that we get back the first treat
        //Run getMyTreat on the second treat
        //assert that we get back the second treat
    }

    /**
     * Test of updateTreat method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testUpdateTreat() throws Exception {
        //Run updateTreat on the first treat

        //assert that we get back the first treat with new inventory amount
        //Run update on the second treat
        //assert that we get back the second treat with new inventory amount        
    }

}
