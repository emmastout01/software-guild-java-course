/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

import junitparams.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author emmastout
 */
@RunWith(JUnitParamsRunner.class)
public class GreatPartyTest {

    GreatParty party = new GreatParty();

    public GreatPartyTest() {
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

    //This tells JUnit that this should run as a test case.
    @Test
    @Parameters({"30, false",
        "39, true",
        "39, false"
    })
    public void testEverythingFalse(int numCigars, boolean isWeekend) {
        //We want to run GreatParty with inputs of 30 and false, and we expect
        //it to come back false.
        assertFalse(party.greatParty(numCigars, isWeekend));
    }

    @Test
    @Parameters({"50, false", 
                "70, true",
                "61, true",
                "40, true"
    })
    public void testEverythingTrue(int numCigars, boolean isWeekend) {
        //We want to run GreatParty with inputs of 30 and false, and we expect
        //it to come back false.
        assertTrue(party.greatParty(numCigars, isWeekend));
    }
//    
//    @Test
//    public void test50False() {
//        assertTrue(party.greatParty(50, false));
//    }
//    
//    @Test
//    public void test70True() {
//        assertTrue(party.greatParty(70, true));
//    }
//    
//     @Test
//    public void test39True() {
//        assertFalse(party.greatParty(39, true));
//    }
//    
//     @Test
//    public void test39False() {
//        assertFalse(party.greatParty(39, false));
//    }
//    

//    @Test
//    public void test40True() {
//        assertTrue(party.greatParty(40, true));
//    }
//
//    @Test
//    public void test60True() {
//        assertTrue(party.greatParty(60, true));
//    }
//
//    @Test
//    public void test61True() {
//        assertTrue(party.greatParty(61, true));
//    }

//    @Test
//    public void test61False() {
//        assertFalse(party.greatParty(61, false));
//    }

}
