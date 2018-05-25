/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.powerball.controllers;

import com.sg.powerball.models.Powerball;
import com.sg.powerball.models.Ticket;
import com.sg.powerball.services.TicketService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author emmastout
 */
@Controller
public class PowerballController {

    @Autowired
    private TicketService ticketService;
    
    @GetMapping
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/buyTicket")
    public String buyTicket(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "buyTicket";
    }

    @PostMapping("/buyTicket")
    public String buyTicket(@Valid Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ticket", ticket);
            System.out.println("Error with ticket: " + ticket);
            return "buyTicket";
        } else {
             ticketService.addTicket(ticket);
            return "redirect:/";
        }
    }

    @GetMapping("/buyQuickPick")
    public String buyQuickPick(Model model) {
            model.addAttribute("ticket", new Ticket());
            return "buyQuickPick";
    }
    
    @PostMapping("/buyQuickPick")
    public String buyQuickPick(@Valid Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ticket", ticket);
            return "buyQuickPick";
        } else {
             ticketService.addTicketGenerateNumbers(ticket);
            return "redirect:/";
        }
    }


    @GetMapping("/drawPowerball")
    public String drawPowerball(Model model) {
        Powerball newPowerball = ticketService.drawPowerball();
        model.addAttribute("powerball", newPowerball);
        model.addAttribute("winner", ticketService.getWinner(newPowerball));
        return "drawPowerball";
    }

}
