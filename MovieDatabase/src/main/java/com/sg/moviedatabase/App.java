/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase;

import com.sg.moviedatabase.controller.MovieDatabaseController;
import com.sg.moviedatabase.dao.MovieDatabaseDao;
import com.sg.moviedatabase.dao.MovieDatabaseDaoException;
import com.sg.moviedatabase.dao.MovieDatabaseDaoFileImpl;
import com.sg.moviedatabase.ui.MovieDatabaseView;
import com.sg.moviedatabase.ui.UserIO;
import com.sg.moviedatabase.ui.UserIOConsoleImpl;

/**
 *
 * @author emmastout
 */
public class App {

    public static void main(String[] args) throws MovieDatabaseDaoException {
        
        UserIO myIo = new UserIOConsoleImpl();
        MovieDatabaseDao myDao = new MovieDatabaseDaoFileImpl();
        MovieDatabaseView myView = new MovieDatabaseView(myIo);
        MovieDatabaseController controller = new MovieDatabaseController(
                myView, myDao);
        controller.run();
    }
}