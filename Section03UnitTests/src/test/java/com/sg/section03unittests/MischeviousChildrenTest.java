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
public class MischeviousChildrenTest {
    
    MischeviousChildren children = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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
    public void testTrueTrue() {
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(children.areWeInTrouble(true, true));
    }
    
    @Test
    public void testFalseFalse() {
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(children.areWeInTrouble(false, false));
    }
    
    @Test
    public void testTrueFalse() {
        // TODO review the generated test code and remove the default call to fail.
        assertFalse(children.areWeInTrouble(true, false));
    }
    
}
