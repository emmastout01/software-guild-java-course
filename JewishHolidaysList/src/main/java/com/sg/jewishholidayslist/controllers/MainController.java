/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jewishholidayslist.controllers;

import com.sg.jewishholidayslist.models.Holiday;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author emmastout
 */

@Controller
public class MainController {
    
    private static final List<Holiday> holidays = new ArrayList<>();
    
    @GetMapping
      //Here, we return a string because we're returning the (string) name of a template
    public String getHolidays(Model model) {
        model.addAttribute("holidays", holidays);
        return "holidays";
    }
    
    
    
    @PostMapping("/addHoliday") 
    //Here, we return a string because we're returning the (string) name of a route
    public String addHoliday(Holiday holiday) {
//        Model model, String holidayName, String startDate, String endDate, String description
//        Holiday holiday = new Holiday(holidayName, startDate, endDate, description);
        holidays.add(holiday);
        System.out.println("Holiday: " + holiday);
        System.out.println("Holiday list: " + holidays);
        return "redirect:/";
    }
}
