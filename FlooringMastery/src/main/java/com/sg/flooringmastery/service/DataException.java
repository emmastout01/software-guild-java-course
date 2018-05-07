/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

/**
 *
 * @author emmastout
 */
public class DataException extends Exception {

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Exception innerEx) {
        super(message, innerEx);
    }

}
