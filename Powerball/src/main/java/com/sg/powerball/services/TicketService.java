/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.powerball.services;

import com.sg.powerball.data.TicketDao;
import com.sg.powerball.models.Powerball;
import com.sg.powerball.models.Ticket;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author emmastout
 */
@Service
public class TicketService {
    
    @Autowired
    private TicketDao ticketDao;

    //Add a ticket
    public Ticket addTicket(Ticket ticket) {
        
        if (isTicketValid(ticket)) {
            return ticketDao.addTicket(ticket);
        } else {
            return null;
        }
    }
    
    public Ticket addTicketGenerateNumbers(Ticket ticket) {
        //Generate 5 numbers that are between 1-69 and different from one another
        Random random = new Random();
        
        int numberOne = random.nextInt(69) + 1;
        int numberTwo = random.nextInt(69) + 1;
        int numberThree = random.nextInt(69) + 1;
        int numberFour = random.nextInt(69) + 1;
        int numberFive = random.nextInt(69) + 1;
        int powerballNumber = random.nextInt(26) + 1;
        
        while (numberOne == numberTwo) {
            numberTwo = random.nextInt(69) + 1;
        }
        
        while (numberThree == numberTwo || numberThree == numberOne) {
            numberThree = random.nextInt(69) + 1;
        }
        
        while (numberFour == numberThree || numberFour == numberTwo
                || numberFour == numberOne) {
            numberFour = random.nextInt(69) + 1;
        }
        
        while (numberFive == numberFour || numberFive == numberThree
                || numberFive == numberTwo || numberFive == numberOne) {
            numberFive = random.nextInt(69) + 1;
        }
        
        ticket.setNumberOne(numberOne);
        ticket.setNumberTwo(numberTwo);
        ticket.setNumberThree(numberThree);
        ticket.setNumberFour(numberFour);
        ticket.setNumberFive(numberFive);
        ticket.setPowerballNumber(powerballNumber);
        
        if (isTicketValid(ticket)) {
            return ticketDao.addTicket(ticket);
        } else {
            return null;
        }
        
    }
    
    private boolean isTicketValid(Ticket ticket) {
        //Check if all 5 numbers are filled in, different from one another, and between 1-69
        //Check if last number is between 1-26

        int numberOne = ticket.getNumberOne();
        int numberTwo = ticket.getNumberTwo();
        int numberThree = ticket.getNumberThree();
        int numberFour = ticket.getNumberFour();
        int numberFive = ticket.getNumberFive();
        int powerballNumber = ticket.getPowerballNumber();
        
        if (numberOne < 1 || numberOne > 69
                || numberTwo < 1 || numberTwo > 69
                || numberThree < 1 || numberThree > 69
                || numberFour < 1 || numberFour > 69
                || numberFive < 1 || numberFive > 69
                || powerballNumber < 1 || powerballNumber > 26) {
            return false;
        } else if (numberOne == numberTwo || numberOne == numberThree || numberOne == numberFour
                || numberOne == numberFive || numberTwo == numberThree
                || numberTwo == numberFour || numberTwo == numberFive
                || numberThree == numberFour || numberThree == numberFive
                || numberFour == numberFive) {
            return false;
        } else {
            return true;
        }
    }
    
    public Powerball drawPowerball() {
        //Generate 5 numbers that are between 1-69 and different from one another
        Powerball powerball = new Powerball();
        Random random = new Random();
        
        int numberOne = random.nextInt(69) + 1;
        int numberTwo = random.nextInt(69) + 1;
        int numberThree = random.nextInt(69) + 1;
        int numberFour = random.nextInt(69) + 1;
        int numberFive = random.nextInt(69) + 1;
        int powerballNumber = random.nextInt(26) + 1;
        
        while (numberOne == numberTwo) {
            numberTwo = random.nextInt(69) + 1;
        }
        
        while (numberThree == numberTwo || numberThree == numberOne) {
            numberThree = random.nextInt(69) + 1;
        }
        
        while (numberFour == numberThree || numberFour == numberTwo
                || numberFour == numberOne) {
            numberFour = random.nextInt(69) + 1;
        }
        
        while (numberFive == numberFour || numberFive == numberThree
                || numberFive == numberTwo || numberFive == numberOne) {
            numberFive = random.nextInt(69) + 1;
        }
        
        powerball.setNumberOne(numberOne);
        powerball.setNumberTwo(numberTwo);
        powerball.setNumberThree(numberThree);
        powerball.setNumberFour(numberFour);
        powerball.setNumberFive(numberFive);
        powerball.setPowerball(powerballNumber);
        
        return ticketDao.drawPowerball(powerball);
    }
    
    public List<Ticket> getWinner(Powerball powerball) {
        List<Ticket> winners = ticketDao.getWinner(powerball);
        ticketDao.updateTicketStatus();
        return winners;
    }
}
