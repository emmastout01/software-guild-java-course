/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.powerball.data;

import com.sg.powerball.models.SearchCriteria;
import com.sg.powerball.models.Powerball;
import com.sg.powerball.models.Ticket;
import java.util.List;

/**
 *
 * @author emmastout
 */
public interface TicketDao {
    
      Ticket addTicket(Ticket ticket);
      
      List<Ticket> searchByCriteria(SearchCriteria criteria);
      
      boolean updateTicketStatus();
      
      Powerball drawPowerball(Powerball powerball);

    List<Ticket> getWinner(Powerball powerball);
    
    boolean addTicketManualEntry(Ticket ticket);
}
