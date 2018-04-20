/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.dao;

/**
 *
 * @author emmastout
 */
public class MovieDatabaseDaoException extends Exception {
        public MovieDatabaseDaoException(String message) {
         super(message);
     }
     
     public MovieDatabaseDaoException(String message, Throwable cause) {
         super(message, cause);
     }
     
}
