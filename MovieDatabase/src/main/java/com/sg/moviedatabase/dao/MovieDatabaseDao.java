/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.dao;

import com.sg.moviedatabase.dto.Movie;
import java.util.List;

/**
 *
 * @author emmastout
 */
public interface MovieDatabaseDao {
    //List movies
    List<Movie> getAllMovies()
            throws MovieDatabaseDaoException;
    
    //Add movie
    Movie addMovie(String movieTitle, Movie movie) 
            throws MovieDatabaseDaoException;
    
    //View movie based on title
    Movie viewMovie(String movieTitle)
            throws MovieDatabaseDaoException;
    
    //Edit movie
    Movie editMovie(String movieTitle, Movie movie)
            throws MovieDatabaseDaoException;
    
    //Revome movie
    Movie removeMovie(String movieTitle)
            throws MovieDatabaseDaoException;
    
    List<Movie> searchMovies(String input)
            throws MovieDatabaseDaoException;
}
