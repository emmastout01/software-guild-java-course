/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Treat;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class JDBCTemplateDao implements VendingMachineDao {

    @Autowired
    private JdbcTemplate jt;

    public JDBCTemplateDao(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public List<Treat> getTreats() throws VendingMachinePersistenceException {
        return jt.query("SELECT * FROM Treat;", new TreatMapper());
    }

    @Override
    public Treat getMyTreat(int TreatId) throws VendingMachinePersistenceException {
        String sql = "SELECT * FROM Treat"
                + " WHERE Id LIKE ?;";
        try {
            return jt.queryForObject(sql, new TreatMapper(), TreatId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public Treat updateTreat(int treatId) throws VendingMachinePersistenceException {

        String sql = "UPDATE Treat SET"
                + " Inventory = ? "
                + " WHERE Id = ?;";

        Treat myTreat = getMyTreat(treatId);
        int newInventory = myTreat.getInventory() - 1;

        int whatIsThis = jt.update(sql, newInventory, treatId);
        System.out.println("jt update: " + whatIsThis);
        return myTreat;
    }

    private static final class TreatMapper implements RowMapper<Treat> {

        @Override
        public Treat mapRow(ResultSet rs, int i) throws SQLException {
            Treat treat = new Treat(rs.getInt("Id"));
            treat.setName(rs.getString("TreatName"));
            treat.setCost(new BigDecimal(rs.getString("Cost")));
            treat.setInventory(rs.getInt("Inventory"));

            return treat;
        }

    }
}
