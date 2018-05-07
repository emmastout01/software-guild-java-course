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
public class ValidationResponse<T> {

    private boolean success = true;
    private String message = "";
    private Order order;
    private T payload;

    public String getMessage() {
        return message;
    }

    public void addToMessage(String message) {
        this.message += message + "\n";
        this.success = false;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

}
