/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.stoctdb;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

/**
 *
 * @author emmastout
 */
@Component
public class DataDao {

    JdbcTemplate jt;
    
    public DataDao(){
        try {
            jt = getJdbcTemplate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
    

    @Bean
    public DataSourceTransactionManager getTransactionManager() throws Exception {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() throws Exception {
        return new JdbcTemplate(getDataSource());
    }

    public void insert(Entry entry) {
        jt.update("INSERT INTO StockHistory (ID, Company, actualDate, "
                + "endOfDay, Volume, startOfDay, High, Low) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);",
                entry.getId(),
                entry.getCompany(),
                entry.getDate(),
                entry.getClose(),
                entry.getVolume(),
                entry.getOpen(),
                entry.getHigh(),
                entry.getLow()
        );
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static DataSource getDataSource() throws Exception {

        MysqlDataSource source = new MysqlDataSource();
        source.setServerName("localhost");
        source.setDatabaseName("StockTracker");
        source.setUser("root");
        source.setPassword("1234");
        source.setServerTimezone("UTC");
        source.setUseSSL(false);

        return source; 
    }

}
