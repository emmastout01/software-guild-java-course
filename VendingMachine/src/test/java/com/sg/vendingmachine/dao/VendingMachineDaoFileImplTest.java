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
        /*We are assuming that 4 Treats already exist in our file:
        1 . Snickers
        Cost: 1.50
        Inventory: will vary
        
        2. Butterfingers
        Cost: 1.75
        Inventory: will vary
        
        3. Potato Chips
        Cost: 1.25
        Inventory: will vary
        
         3. Zebra Cakes
        Cost: 2.75
        Inventory: will vary
         */
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
        List<Treat> treatList = dao.getTreats();

        //Assert that all 4 treats are in the getTreats file
        assertEquals(4, treatList.size());
    }

    /**
     * Test of getMyTreat method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testGetMyTreat() throws Exception {
        //Run getMyTreat on the first treat
        Treat treat1 = dao.getMyTreat(1);
        //assert that we get back the first treat
        assertEquals("Snickers", treat1.getName());
        
        //Run getMyTreat on the second treat
           Treat treat2 = dao.getMyTreat(2);
        //assert that we get back the second treat
        assertEquals("Butterfingers", treat2.getName());

    }

    /**
     * Test of updateTreat method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testUpdateTreat() throws Exception {
        Treat treat1 = dao.getMyTreat(1);
        int treat1Inventory = treat1.getInventory();
        
         //Run updateTreat on the first treat
        Treat treat1Updated = dao.updateTreat(1);
        int treat1UpdatedInventory = treat1Updated.getInventory();
        //assert that we get back the first treat with new inventory amount
        assertEquals((treat1Inventory-1), treat1UpdatedInventory);
        
        Treat treat2 = dao.getMyTreat(2);
        int treat2Inventory = treat2.getInventory();
        
         //Run updateTreat on the first treat
        Treat treat2Updated = dao.updateTreat(2);
        int treat2UpdatedInventory = treat2Updated.getInventory();
        //assert that we get back the first treat with new inventory amount
        assertEquals((treat2Inventory-1), treat2UpdatedInventory);      
    }

}
