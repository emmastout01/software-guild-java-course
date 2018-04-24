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
public class StringTimesTest {

    private StringTimes string = new StringTimes();

    public StringTimesTest() {
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
     * Test of stringTimes method, of class StringTimes.
     */
    @Test
    public void testHello2() {
        assertEquals("HelloHello", string.stringTimes("Hello", 2));
    }

    @Test
    public void testCat4() {
        assertEquals("CatCatCatCat", string.stringTimes("Cat", 4));
    }

    @Test
    public void testPlankton0() {
        assertEquals("", string.stringTimes("Plankton", 0));
    }

    @Test
    public void testWombat1() {
        assertEquals("Wombat", string.stringTimes("Wombat", 1));
    }

}
