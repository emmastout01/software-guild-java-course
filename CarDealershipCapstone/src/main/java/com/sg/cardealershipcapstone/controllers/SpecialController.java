/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.controllers;

import com.sg.cardealershipcapstone.services.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author emmastout
 */
@Controller
public class SpecialController {
    
    @Autowired
    private SpecialService service;
}
