/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

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
public class SumDoubleTest {
    
    SumDouble sum = new SumDouble();
    
    public SumDoubleTest() {
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

    
      // sumDouble(1, 2) -> 3
    // sumDouble(3, 2) -> 5
    // sumDouble(2, 2) -> 8

    
    @Test
    public void test1And2() {
        assertEquals(3, sum.sumDouble(1, 2));
    }
    
     @Test
    public void test3And14() {
        assertEquals(17, sum.sumDouble(3, 14));
    }
    
     @Test
    public void test2And2() {
        assertEquals(8, sum.sumDouble(2, 2));
    }
    
     @Test
    public void testNeg10And10() {
        assertEquals(0, sum.sumDouble(-10, 10));
    }
}
