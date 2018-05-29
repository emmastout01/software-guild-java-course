/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.powerball.data;

import com.sg.powerball.models.SearchCriteria;
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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author emmastout
 */
@Component
public class TicketJdbcTemplateDao implements TicketDao {

    @Autowired
    private JdbcTemplate jt;

    List<Ticket> matching1 = new ArrayList<>();
    List<Ticket> matching2 = new ArrayList<>();
    List<Ticket> matching3 = new ArrayList<>();
    List<Ticket> matching4 = new ArrayList<>();
    List<Ticket> matching5 = new ArrayList<>();
    List<Ticket> matching6 = new ArrayList<>();

    @Override
    @Transactional
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

        int id = jt.queryForObject("select LAST_INSERT_ID();", Integer.class);

        ticket.setId(id);
        return ticket;
    }

    @Override
    public boolean addTicketManualEntry(Ticket ticket) {        
        String sql = "UPDATE Ticket SET PickType = ?"
                + "WHERE TicketId = ?;";

        return jt.update(sql, "Manual", ticket.getId()) > 0;
    }

    @Override
    public boolean updateTicketStatus() {
        //This method needs some work. I want to change the status of all tickets
        //purchased before the powerball was drawn, not update a specific ticket. 
        String sql = "UPDATE Ticket SET TicketStatus = ?"
                + "WHERE TicketStatus = ?;";

        return jt.update(sql, "expired", "active") > 0;
    }

    @Override
    public List<Ticket> searchByCriteria(SearchCriteria criteria) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT * FROM Ticket WHERE"
                + "(? IS NULL or TicketId LIKE ?)"
                + "AND (? IS NULL or FirstName LIKE ?) "
                + "AND (? IS NULL or LastName LIKE ?)"
                + "AND (? IS NULL or Email LIKE ?)"
                + "AND (? IS NULL or State LIKE ?)"
                + "AND (? IS NULL or TicketStatus LIKE ?)"
                + "AND (? IS NULL or PickType LIKE ?);";

        String lastName = criteria.getLastName();
        
        return jt.query(sql,
                new TicketMapper(),
                criteria.getId(), criteria.getId(),
                criteria.getFirstName(), criteria.getFirstName(),
                criteria.getLastName(), criteria.getLastName(),
                criteria.getEmail(), criteria.getEmail(),
                criteria.getState(), criteria.getState(),
                criteria.getStatus(), criteria.getStatus(),
                criteria.getPickType(), criteria.getPickType()
        );

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
    public List<Ticket> getWinner(Powerball powerball) {
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

            int matchingNumbers
                    = this.getMatchingNumbers(ticketNumbers, powerballNumbers);
            if (ticket.getPowerballNumber() == powerball.getPowerball()) {
                matchingNumbers++;
            }

            this.addToWinnerArray(matchingNumbers, ticket);
        }

        List<Ticket> winnerArray = this.getWinnerArray();

        return winnerArray;
    }

    private void addToWinnerArray(int matchingNumbers, Ticket ticket) {

        switch (matchingNumbers) {
            case 1:
                matching1.add(ticket);
                break;
            case 2:
                matching2.add(ticket);
                break;
            case 3:
                matching3.add(ticket);
                break;
            case 4:
                matching4.add(ticket);
                break;
            case 5:
                matching5.add(ticket);
                break;
            case 6:
                matching6.add(ticket);
                break;
        }
    }

    private List<Ticket> getWinnerArray() {
        List<Ticket> winners;
        if (matching6.toArray().length > 0) {
            winners = new ArrayList<>(matching6);
            this.emptyArrays();
            return winners;
        } else if (matching5.toArray().length > 0) {
            winners = matching5;
            this.emptyArrays();
            return winners;
        } else if (matching4.toArray().length > 0) {
            winners = matching4;
            this.emptyArrays();
            return winners;
        } else if (matching3.toArray().length > 0) {
            winners = matching3;
            this.emptyArrays();
            return winners;
        } else if (matching2.toArray().length > 0) {
            winners = matching2;
            this.emptyArrays();
            return winners;
        } else if (matching1.toArray().length > 0) {
            winners = matching1;
            this.emptyArrays();
            return winners;
        } else {
            return null;
        }
    }

    private int getMatchingNumbers(List<Integer> ticketNumbers, List<Integer> powerballNumbers) {
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
                    "SELECT * FROM Ticket WHERE TicketStatus = ?",
                    new TicketMapper(),
                    "active");
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private void emptyArrays() {
        this.matching1.clear();
        this.matching2.clear();
        this.matching3.clear();
        this.matching4.clear();
        this.matching5.clear();
        this.matching6.clear();
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
