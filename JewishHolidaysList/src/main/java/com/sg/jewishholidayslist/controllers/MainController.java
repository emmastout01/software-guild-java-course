/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jewishholidayslist.controllers;

import com.sg.jewishholidayslist.models.Holiday;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.spi.DirStateFactory.Result;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author emmastout
 */
@Controller
public class MainController {
    
    private final Map<Integer, Holiday> holidays = new HashMap<>();

//    private static final List<Holiday> holidays = new ArrayList<>();

    @GetMapping
    //Here, we return a string because we're returning the (string) name of a template
    public String getHolidays(Model model) {
        model.addAttribute("holidays", holidays);
        return "holidays";
    }

    @GetMapping("/addHoliday")
    public String addHoliday(Model model) {
        model.addAttribute("holiday", new Holiday());
        return "add-holiday";
    }

    @PostMapping("/addHoliday")
    //Here, we return a string because we're returning the (string) name of a route
    public String addHoliday(@Valid Holiday holiday, BindingResult result, Model model) {
//        Model model, String holidayName, String startDate, String endDate, String description
//        Holiday holiday = new Holiday(holidayName, startDate, endDate, description);
        if (result.hasErrors()) {
            model.addAttribute("holiday", holiday);
            return "add-holiday";
        } else {
      
        int id; 
        
        List<Holiday> holidayList = new ArrayList<>(holidays.values());

        if (holidays.size() > 0) {
            int maxId = holidayList.stream()
                    .mapToInt(h -> h.getId())
                    .max()
                    .getAsInt();
            id = maxId + 1;
        } else {
            id = 1;
        }

        holiday.setId(id);
        holidays.put(id, holiday);
            return "redirect:/";
        }
    }

    @GetMapping("/editHoliday/{holidayId}")
    public String editHoliday(Model model, @PathVariable int holidayId) {
        
        Holiday h = holidays.get(holidayId);
        
        if (h == null) {
            return "redirect:/";
        }
        model.addAttribute("holiday", h);
        return "edit-holiday";
        
    }
    
    @PostMapping("/editHoliday/{holidayId}")
    public String editHoliday(@Valid Holiday holiday, BindingResult result, Model model) {
         if (result.hasErrors()) {
            model.addAttribute("holiday", holiday);
            return "edit-holiday";
        } else {
            holidays.put(holiday.getId(), holiday);
            return "redirect:/";
        }
    }

    @GetMapping("/deleteHoliday/{holidayId}") 
    public String deleteHoliday(Model model, @PathVariable int holidayId) {
        Holiday h = holidays.get(holidayId);
        
        if (h == null) {
            return "redirect:/";
        }
        model.addAttribute("holiday", h);
        return "delete-holiday";
    }
    
    @PostMapping("/deleteHoliday/{holidayId}")
    public String deleteHoliday(Holiday holiday, Model model) {
        
        holidays.remove(holiday.getId());
        return "redirect:/";
    }
    
}
