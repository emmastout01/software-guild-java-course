/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author emmastout
 */
public class VendingMachineServiceImplTest {

    //Stub data: We have a list of three treats:
    //treat 1 id = 1
//      treat1.setName("100 Grand");
//        treat1.setCost(BigDecimal.ONE);
//        treat1.setInventory(3);
//
//        Treat treat2 = new Treat(2);
//
    //treat 2 id = 2
//        treat2.setName("Milky Way");
//        treat2.setCost(BigDecimal.TEN);
//        treat2.setInventory(5);
//
//        Treat treat3 = new Treat(3);
//
    //treat 3 id = 3
//        treat3.setName("Skittles");
//        treat3.setCost(BigDecimal.TEN);
//        treat3.setInventory(0);
    
    VendingMachineDao dao = new VendingMachineDaoStubImpl();
    VendingMachineService service = new VendingMachineServiceImpl(dao);

    public VendingMachineServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of purchaseTreat method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testPurchaseTreatValid() throws Exception {

        BigDecimal addedMoney = new BigDecimal("10.25");
        int treatIdIn = 1;
       
        //Confirm that this test will NOT throw an error since it should be valid
            service.purchaseTreat(addedMoney, treatIdIn);
      
    }

@Test
        public void testPurchaseTreatInsufficientFunds() throws Exception {
        //Check if it throws an error when user has insufficient funds
        
         BigDecimal addedMoney = new BigDecimal("7.25");
        int treatIdIn = 2;
        
          try {
            service.purchaseTreat(addedMoney, treatIdIn);
            fail("Expected InsufficientFundsException was not thrown.");
        } catch (InsufficientFundsException e) {
            return;
        }
    }
    
     @Test
        public void testPurchaseTreatOutOfStock() throws Exception {
        //Check that it throws an error if item is out of stock
        
        BigDecimal addedMoney = new BigDecimal("7.25");
        //Try with a treat where inventory = 0
        int treatIdIn = 3;
        
          try {
            service.purchaseTreat(addedMoney, treatIdIn);
            fail("Expected OutOfStockException was not thrown.");
        } catch (OutOfStockException e) {
            return;
        }
    }


    /**
     * Test of getTreats method, of class VendingMachineServiceImpl.
     */
    @Test
        public void testGetTreats() throws Exception {
        //Check that it only gets back the treats that are in stock
        assertEquals(2, service.getTreats().size());
        
    }
    
}
