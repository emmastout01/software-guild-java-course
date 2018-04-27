/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import java.math.BigDecimal;
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
public class ChangeTest {
    
    
    public ChangeTest() {
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

    @Test
    public void test1() {
       BigDecimal myChange = new BigDecimal("1.02");
    Change change = new Change(myChange);
        assertEquals(change.getQuarters(), 4);
        assertEquals(change.getDimes(), 0);
        assertEquals(change.getNickels(), 0);
        assertEquals(change.getPennies(), 2);
    }
    
     @Test
    public void test2() {
       BigDecimal myChange = new BigDecimal("1.16");
    Change change = new Change(myChange);
        assertEquals(change.getQuarters(), 4);
        assertEquals(change.getDimes(), 1);
        assertEquals(change.getNickels(), 1);
        assertEquals(change.getPennies(), 1);
    }
    
     @Test
    public void test3() {
       BigDecimal myChange = new BigDecimal(".42");
    Change change = new Change(myChange);
        assertEquals(change.getQuarters(), 1);
        assertEquals(change.getDimes(), 1);
        assertEquals(change.getNickels(), 1);
        assertEquals(change.getPennies(), 2);
    }
    
     @Test
    public void test4() {
       BigDecimal myChange = new BigDecimal("1.27");
    Change change = new Change(myChange);
        assertEquals(change.getQuarters(), 5);
        assertEquals(change.getDimes(), 0);
        assertEquals(change.getNickels(), 0);
        assertEquals(change.getPennies(), 2);
    }
    
     @Test
    public void test5() {
       BigDecimal myChange = new BigDecimal("0");
    Change change = new Change(myChange);
        assertEquals(change.getQuarters(), 0);
        assertEquals(change.getDimes(), 0);
        assertEquals(change.getNickels(), 0);
        assertEquals(change.getPennies(), 0);
    }
    
     @Test
    public void test6() {
       BigDecimal myChange = new BigDecimal(".01");
    Change change = new Change(myChange);
        assertEquals(change.getQuarters(), 0);
        assertEquals(change.getDimes(), 0);
        assertEquals(change.getNickels(), 0);
        assertEquals(change.getPennies(), 1);
    }
    
}
