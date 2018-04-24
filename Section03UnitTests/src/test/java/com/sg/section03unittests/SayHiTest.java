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
public class SayHiTest {

    private SayHi hi = new SayHi();

    public SayHiTest() {
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
     * Test of sayHi method, of class SayHi.
     */
    @Test
    public void testCindy() {
        assertEquals("Hello Cindy!", hi.sayHi("Cindy"));
    }

    @Test
    public void testBarry() {
        assertEquals("Hello Barry!", hi.sayHi("Barry"));
    }

    @Test
    public void testWaldo() {
        assertEquals("Hello Waldo!", hi.sayHi("Waldo"));
    }
}
