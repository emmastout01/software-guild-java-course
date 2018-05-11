/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.stoctdb;

import java.util.List;

/**
 *
 * @author emmastout
 */
public class App {

    public static void main(String[] args) throws Exception {
        String applPath = "historical_stock_aapl.csv";
        String msftPath = "historical_stock_msft.csv";
        String orclPath = "historical_stock_orcl.csv";
        String apple = "aapl";
        String micro = "msft";
        String oracle = "orcl";

        FileDao fileDao = new FileDao();
        DataDao dataDao = new DataDao();
        
        List<Entry> entryList = fileDao.all(applPath, apple);
        
        for(Entry entry : entryList) {
             dataDao.insert(entry);
        }
        
       
    }

}
