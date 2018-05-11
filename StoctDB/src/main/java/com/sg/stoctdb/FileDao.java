/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.stoctdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class FileDao {

    private String applPath = "historical_stock_aapl.csv";
    private String msftPath = "historical_stock_msft.csv";
    private String orclPath = "historical_stock_orcl.csv";
    private String apple = "aapl";
    private String micro = "msft";
    private String oracle = "orcl";
    

    List<Entry> all(String path, String company) throws Exception {
        List<Entry> dataResult = new ArrayList<>();
        Scanner scanner;
        char QUOTE = '"';
        String COMMA = ",";
        String DELIMITER = QUOTE + COMMA + QUOTE;
        
        
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File Not Found");
            return dataResult;
        }

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(file)));
        } catch (FileNotFoundException e) {
            throw new Exception(
                    "Could not load order into file.", e);
        }
        
            String line;
            scanner.nextLine();
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokens = line.split(DELIMITER);
                if (tokens.length == 6) {
                    Entry e = new Entry();
                    
                    String correctedDate = tokens[0].substring(1);
                    
                    e.setDate(LocalDate.parse(correctedDate, 
                            DateTimeFormatter.ofPattern("yyyy/MM/dd")).toString());
                    e.setClose(new BigDecimal(tokens[1]));
                    e.setVolume(new BigDecimal(tokens[2]));
                    e.setOpen(new BigDecimal(tokens[3]));
                    e.setHigh(new BigDecimal(tokens[4]));
                    
                    String correctedLow = 
                            tokens[5].substring(0, tokens[5].length() -1);
                    
                    e.setLow(new BigDecimal(correctedLow));
                    e.setId(company + e.getDate());
                    e.setCompany(company);
                    dataResult.add(e);
                    
                }
            }
            
            return dataResult;
        }

    }
