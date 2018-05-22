/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculator.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author emmastout
 */
@Controller
public class TipController {

    
    @PostMapping("/calc")
    public String calculateTip(int amount, int tipPercent, Model model) {
        BigDecimal amountBD = BigDecimal.valueOf(amount);
        BigDecimal tipPercentBD = BigDecimal.valueOf(tipPercent);
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal tipPercentInDecimal = tipPercentBD.divide(hundred, 2, RoundingMode.HALF_UP);
        BigDecimal tipAmount = amountBD.multiply(tipPercentInDecimal);
        BigDecimal total = tipAmount.add(amountBD);
        
        model.addAttribute("amount", amountBD);
        model.addAttribute("tipPercent", tipPercentBD);
        model.addAttribute("tipAmount", tipAmount);
        model.addAttribute("total", total);      
       
        return "Calculator";
    }
    
    @GetMapping("/calc")
    public String calc() {
        return "Calculator";
    }


}
