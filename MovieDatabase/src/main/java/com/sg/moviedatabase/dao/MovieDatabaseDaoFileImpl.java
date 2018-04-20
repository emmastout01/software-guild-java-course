/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.dao;

import com.sg.moviedatabase.dto.Movie;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class MovieDatabaseDaoFileImpl implements MovieDatabaseDao {

    public static final String MOVIE_DATABASE = "movie_database.txt";
    public static final String DELIMITER = "::";
    private Map<String, Movie> movies = new HashMap<>();

    @Override
    public List<Movie> getAllMovies()
            throws MovieDatabaseDaoException {
        loadMovies();
        return new ArrayList<Movie>(movies.values());
    }

    @Override
    public Movie addMovie(String movieTitle, Movie movie)
            throws MovieDatabaseDaoException {
        movies.put(movieTitle, movie);
        writeMovies(movies.values());
        return movie;

    }

    @Override
    public Movie viewMovie(String movieTitle)
            throws MovieDatabaseDaoException {
        loadMovies();
        Movie movie = movies.get(movieTitle);
        return movie;
    }

    @Override
    public Movie editMovie(String movieTitle, Movie movie)
            throws MovieDatabaseDaoException {
        movies.put(movieTitle, movie);
        writeMovies(movies.values());
        return movie;
    }

    @Override
    public Movie removeMovie(String movieTitle)
            throws MovieDatabaseDaoException {
       loadMovies();
       Movie movieToRemove = movies.get(movieTitle);
       movies.remove(movieTitle);
       writeMovies(movies.values());
       return movieToRemove;
    }

    private void loadMovies() throws MovieDatabaseDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(MOVIE_DATABASE)));
        } catch (FileNotFoundException e) {
            throw new MovieDatabaseDaoException(
                    "Could not load movie into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Movie currentMovie = new Movie(currentTokens[0]);
            currentMovie.setReleaseDate(currentTokens[1]);
            currentMovie.setMpaaRating(currentTokens[2]);
            currentMovie.setDirectorName(currentTokens[3]);
            currentMovie.setStudio(currentTokens[4]);
            currentMovie.setUserRating(currentTokens[5]);

            movies.put(currentMovie.getTitle(), currentMovie);  
        }
        scanner.close();
    }

    private void writeMovies(Collection<Movie> movieList) throws MovieDatabaseDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(MOVIE_DATABASE));
        } catch (IOException e) {
            throw new MovieDatabaseDaoException("Could not save movie data.", e);
        }

//        List<Movie> movieList = this.getAllMovies();

        for (Movie currentMovie : movieList) {
            out.println(currentMovie.getTitle() + DELIMITER
                    + currentMovie.getReleaseDate() + DELIMITER
                    + currentMovie.getMpaaRating() + DELIMITER
                    + currentMovie.getDirectorName() + DELIMITER
                    + currentMovie.getStudio() + DELIMITER
                    + currentMovie.getUserRating());
            out.flush();
        }
        out.close();
    }
}
