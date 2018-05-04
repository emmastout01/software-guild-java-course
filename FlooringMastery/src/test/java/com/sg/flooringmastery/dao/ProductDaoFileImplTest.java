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
public class ProductDaoFileImplTest {
    
    private ProductDao dao = new ProductDaoFileImpl();
    
    @Before
    public void setUp() {
        /*We assume that we start with a file that has
        the following information:
        ProductType,CostPerSquareFoot,LaborCostPerSquareFoot
        Carpet,2.25,2.10
        Laminate,1.75,2.10
        Tile,3.50,4.15
        Wood,5.15,4.75
        */ 
    }


    /**
     * Test of getAllProducts method, of class ProductDaoFileImpl.
     */
    @Test
    public void testGetAllProducts() throws Exception {
        assertEquals(4, dao.getAllProducts().size());
    }

    /**
     * Test of getProduct method, of class ProductDaoFileImpl.
     */
    @Test
    public void testGetProduct() throws Exception {
        assertEquals("Carpet", dao.getProduct("Carpet").getProductType());
        
        BigDecimal testSqFootCost = new BigDecimal("3.50");
        assertEquals(testSqFootCost, dao.getProduct("Tile").getCostPerSqFoot());
        
        BigDecimal testLaborCost = new BigDecimal("4.75");
        assertEquals(testLaborCost, dao.getProduct("Wood")
                .getLaborCostPerSqFoot());
    }
    
}
