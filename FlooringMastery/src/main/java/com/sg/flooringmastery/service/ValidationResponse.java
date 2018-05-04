/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.models.Order;

/**
 *
 * @author emmastout
 */
public class ValidationResponse {

    private boolean success;
    private String message = "";
    private Order order;

    public String getMessage() {
        return message;
    }

    public void addToMessage(String message) {
        this.message += message + "\n";
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public boolean isSuccess() {
        return success;
    }

}
