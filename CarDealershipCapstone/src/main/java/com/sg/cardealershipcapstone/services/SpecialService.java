/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.services;

import com.sg.cardealershipcapstone.data.SpecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author emmastout
 */
@Service
public class SpecialService {
    
    
    @Autowired
    SpecialRepository repo;
}
