/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.powerball.data;

import com.sg.powerball.models.Powerball;
import com.sg.powerball.models.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author emmastout
 */
@Component
public class TicketJdbcTemplateDao implements TicketDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public Ticket addTicket(Ticket ticket) {

        String sql = "INSERT INTO Ticket (FirstName, LastName, Email, State, "
                + "NumberOne, NumberTwo, NumberThree, NumberFour, NumberFive, "
                + "PowerballNumber ) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jt.update(sql,
                ticket.getFirstName(),
                ticket.getLastName(),
                ticket.getEmail(),
                ticket.getState(),
                ticket.getNumberOne(),
                ticket.getNumberTwo(),
                ticket.getNumberThree(),
                ticket.getNumberFour(),
                ticket.getNumberFive(),
                ticket.getPowerballNumber()
        );

        int id = jt.queryForObject("select LAST_INSERT_ID()", Integer.class);

        ticket.setId(id);
        return ticket;
    }

    @Override
    public boolean updateTicketStatus(Ticket ticket) {
        //This method needs some work. I want to change the status of all tickets
        //purchased before the powerball was drawn, not update a specific ticket. 
        String sql = "UPDATE Ticket SET Status = ?"
                + "WHERE TicketId = ?;";

        return jt.update(sql, "expired", ticket.getId()) > 0;
    }

    @Override
    public List<Ticket> searchByCriteria(SearchCriteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        String sql = "SELECT * FROM Ticket WHERE"
//                + "? IS NULL or FirstName LIKE ? "
//                + "AND (? IS NULL or LastName LIKE ?)"
//                + "AND ? IS NULL or State LIKE ?"
//                + "AND ? IS NULL or LastName LIKE ?"
//                + "AND ? IS NULL or LastName LIKE ?"
//                
    }

    public Powerball drawPowerball(Powerball powerball) {
        String sql = "INSERT INTO Powerball (NumberOne, NumberTwo, NumberThree, "
                + "NumberFour, NumberFive, PowerballNumber ) "
                + "VALUES (?, ?, ?, ?, ?, ?);";

        jt.update(sql,
                powerball.getNumberOne(),
                powerball.getNumberTwo(),
                powerball.getNumberThree(),
                powerball.getNumberFour(),
                powerball.getNumberFive(),
                powerball.getPowerball());

        return powerball;
    }

    @Override
    public Ticket getWinner(Powerball powerball) {
        //Here, I need to get all the tickets that have any matches with 
        //Put all active tickets into a set, loop through the set and if any numbers match the powerball, th
        List<Ticket> activeTickets = this.getAllActiveTickets();
        List<Integer> powerballNumbers = new ArrayList<>();

        powerballNumbers.add(powerball.getNumberOne());
        powerballNumbers.add(powerball.getNumberTwo());
        powerballNumbers.add(powerball.getNumberThree());
        powerballNumbers.add(powerball.getNumberFour());
        powerballNumbers.add(powerball.getNumberFive());

        for (Ticket ticket : activeTickets) {
            List<Integer> ticketNumbers = new ArrayList<>();
            ticketNumbers.add(ticket.getNumberOne());
            ticketNumbers.add(ticket.getNumberTwo());
            ticketNumbers.add(ticket.getNumberThree());
            ticketNumbers.add(ticket.getNumberFour());
            ticketNumbers.add(ticket.getNumberFive());
            int matchingNumbers = 
                    this.getMatchingNumbers(ticketNumbers, powerballNumbers);
        }

    }

    private int getMatchingNumbers
        (List<Integer> ticketNumbers, List<Integer> powerballNumbers) {
            int matchingNumbers = 0;
             for (int number : ticketNumbers) {
                for (int pnumber : powerballNumbers) {
                    if (number == pnumber) {
                        matchingNumbers++;
                    }
                }
            }
             return matchingNumbers;
        }
    
    
    private List<Ticket> getAllActiveTickets() {
        try {
            return jt.query(
                    "SELECT * FROM Book WHERE TicketStatus = ?",
                    new TicketMapper(),
                    "active");
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final class TicketMapper implements RowMapper<Ticket> {

        @Override
        public Ticket mapRow(ResultSet rs, int i) throws SQLException {
            Ticket t = new Ticket();
            t.setFirstName(rs.getString("FirstName"));
            t.setLastName(rs.getString("LastName"));
            t.setEmail(rs.getString("Email"));
            t.setState(rs.getString("State"));
            t.setStatus(rs.getString("TicketStatus"));
            t.setTimeStamp(rs.getTimestamp("PurchaseTime").toLocalDateTime());
            t.setNumberOne(rs.getInt("NumberOne"));
            t.setNumberTwo(rs.getInt("NumberTwo"));
            t.setNumberThree(rs.getInt("NumberThree"));
            t.setNumberFour(rs.getInt("NumberFour"));
            t.setNumberFive(rs.getInt("NumberFive"));
            t.setPowerballNumber(rs.getInt("PowerballNumber"));
            return t;
        }
    }

}
