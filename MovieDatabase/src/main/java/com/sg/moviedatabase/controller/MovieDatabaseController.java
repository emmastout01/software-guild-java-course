/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.controller;

import com.sg.moviedatabase.dao.MovieDatabaseDao;
import com.sg.moviedatabase.dao.MovieDatabaseDaoException;
import com.sg.moviedatabase.dao.MovieDatabaseDaoFileImpl;
import com.sg.moviedatabase.dto.Movie;
import com.sg.moviedatabase.ui.MovieDatabaseView;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class MovieDatabaseController {
    
    private MovieDatabaseView view;
    private MovieDatabaseDao dao;
    
    public MovieDatabaseController(MovieDatabaseView view, MovieDatabaseDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() throws MovieDatabaseDaoException {
        boolean isRunning = true;

        try {
            while (isRunning) {
                int menuChoice = view.printMenuAndGetSelection();

                switch (menuChoice) {
                    case 1:
                        getAllMovies();
                        break;
                    case 2:
                        addMovie();
                        break;
                    case 3:
                        viewMovie();
                        break;
                    case 4:
                        searchMovies();
                        break;
                    case 5:
                        editMovie();
                        break;
                    case 6: 
                        removeMovie();
                        break;
                    case 7:
                        isRunning = false;
                        break;
                }
            }
            view.displayExitBanner();
        } catch (MovieDatabaseDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void getAllMovies()
            throws MovieDatabaseDaoException {
        //Show banner
        view.displayListMoviesBanner();
        //Grab the list of movies from the DAO and store them in a new list
        List<Movie> movieList = dao.getAllMovies();
        //Display the list of movies via the view
        view.displayMovieList(movieList);
    }

    private void addMovie()
            throws MovieDatabaseDaoException {
        //Show banner
        view.displayAddMovieBanner();
        //Gather info about the new movie from the user via the view
        Movie newMovie = view.getNewMovieInfo();
        //Send this info to the dao, which will store it in the file
        dao.addMovie(newMovie.getTitle(), newMovie);
        //Display a success message
        view.displayAddMovieSuccessBanner();
    }

    private void viewMovie()
            throws MovieDatabaseDaoException {
        //Show banner
        view.displayViewMovieBanner();
        //Gather info from user about which movie they want to see
        String movieTitle = view.getMovieTitleChoice();
        
        //Send this info to dao. Get the movie info back.
        Movie movie = dao.viewMovie(movieTitle);
        //Display movie info
        view.displayMovie(movie);
        
    }

    private void editMovie()
            throws MovieDatabaseDaoException {
        view.displayEditMovieBanner();
        //Get title from user for which movie they want to edit
        String movieTitleToEdit = view.getMovieToEdit();
        //Get movie data for that movie via the dao:
        Movie movieToEdit = dao.viewMovie(movieTitleToEdit);
        //If no such movie exists, let the user know
        if(movieToEdit == null) {
            view.displayNoMovieBanner();
        } else {
             //Get edited data from user
        Movie newMovie = view.getEditMovieInfo(movieToEdit);
        //Write this data to our file using the dao
        dao.editMovie(movieTitleToEdit, newMovie);
        //Let the user know if it worked or not.
        if(dao.editMovie(movieTitleToEdit, newMovie) == newMovie) {
            view.displayEditSuccess(movieTitleToEdit);
        } else {
            view.displayEditFail(movieTitleToEdit);
        }
        }
       
    }

    private void removeMovie()
            throws MovieDatabaseDaoException {
        view.displayRemoveMovieBanner();
        //Get info from user about which movie they want to remove
        String movieTitle = view.getMovieTitleToRemove();
        //Using this info, remove the the movie with this title from file
        Movie movieToRemove = dao.removeMovie(movieTitle);
        if(movieToRemove == null) {
            view.displayNoMovieBanner();
        } else {
            view.displayRemoveSuccessBanner();
        }
    }
    
    private void searchMovies() 
             throws MovieDatabaseDaoException {
        view.displaySearchBanner();
        //Get input from user for what the movie starts with
        String startsWith = view.getSearch();
        //Get movie data for every movie that starts with user input
        List<Movie> movieList = dao.searchMovies(startsWith);
        //Display movies that meet this criteria
        view.displayMovieList(movieList);
    }
}
