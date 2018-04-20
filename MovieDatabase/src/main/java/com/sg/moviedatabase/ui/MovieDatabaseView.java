/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.ui;

import com.sg.moviedatabase.dto.Movie;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class MovieDatabaseView {
    
    private UserIO io;
    
    public MovieDatabaseView(UserIO io) {
        this.io = io;
    }


    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List all movies");
        io.print("2. Add a movie");
        io.print("3. View movie information by title");
        io.print("4. Edit movie information");
        io.print("5. Remove movie from database by title");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public void displayListMoviesBanner() {
        io.print("=== List Movies ===");
    }

    public void displayMovieList(List<Movie> movieList) {
        for (Movie movie : movieList) {
            io.print(movie.getTitle());
            io.print("Release Date: " + movie.getReleaseDate());
            io.print("Rated: " + movie.getMpaaRating());
            io.print("Directed by: " + movie.getDirectorName());
            io.print("Studio: " + movie.getStudio());
            io.print("User rating: " + movie.getUserRating());
            io.print("--------");
        }

    }

    public void displayAddMovieBanner() {
        io.print("=== Add Movie ===");
    }

    public Movie getNewMovieInfo() {
        String title = io.readString("Movie title:");
        String releaseDate = io.readString("Release Date:");
        String rating = io.readString("MPAA Rating:");
        String director = io.readString("Director:");
        String studio = io.readString("Studio:");
        String userRating = io.readString("Your movie rating/comments:");

        Movie newMovie = new Movie(title);
        newMovie.setReleaseDate(releaseDate);
        newMovie.setMpaaRating(rating);
        newMovie.setDirectorName(director);
        newMovie.setStudio(studio);
        newMovie.setUserRating(userRating);

        return newMovie;
    }

    public void displayAddMovieSuccessBanner() {
        io.print("Movie successfully added to the database!");
    }

    public void displayViewMovieBanner() {
        io.print("=== View Movie Information ===");
    }

    public String getMovieTitleChoice() {
        String movieTitle = io.readString("Title of movie that you would "
                + "like more information about: ");
        return movieTitle;
    }

    public void displayMovie(Movie movie) {
        if (movie != null) {
            io.print(movie.getTitle());
            io.print(movie.getReleaseDate());
            io.print(movie.getMpaaRating());
            io.print(movie.getDirectorName());
            io.print(movie.getStudio());
            io.print(movie.getUserRating());
        } else {
            io.print("That movie is not in the database.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayEditMovieBanner() {
        io.print("=== Edit Movie ===");
    } 
    
    public String getMovieToEdit() {
         String movieTitle = io.readString("Title of movie that you would "
                + "like to edit: ");
        return movieTitle;
    }
    
    public Movie getEditMovieInfo(Movie currentMovie) {
        String currentTitle = currentMovie.getTitle();
        String currentRelease = currentMovie.getReleaseDate();
        String currentRating = currentMovie.getMpaaRating();
        String currentDirector = currentMovie.getDirectorName();
        String currentStudio = currentMovie.getStudio();
        String currentUserRating = currentMovie.getUserRating();
                
        
        String title = io.readStringPrintf("Movie title (%s):", currentTitle);
        String releaseDate = io.readStringPrintf("Release Date (%s):", currentRelease);
        String rating = io.readStringPrintf("MPAA Rating (%s):", currentRating);
        String director = io.readStringPrintf("Director (%s):", currentDirector);
        String studio = io.readStringPrintf("Studio (%s):", currentStudio);
        String userRating = io.readStringPrintf
        ("Your movie rating/comments (%s):", currentUserRating);

        
        Movie newMovie;
        
        if(title != null) {
            newMovie = new Movie(title);
        } else {
            newMovie = new Movie(currentTitle);
        }
        if(releaseDate != null) {
           newMovie.setReleaseDate(releaseDate); 
        } else {
            newMovie.setReleaseDate(currentRelease);
        } 
        if (rating != null) {
          newMovie.setMpaaRating(rating);  
        } else {
           newMovie.setMpaaRating(currentRating);  
        }
        if (director != null) {
            newMovie.setDirectorName(director);
        } else {
            newMovie.setDirectorName(currentDirector);
        }
        if (studio != null) {
            newMovie.setStudio(studio);
        } else {
            newMovie.setStudio(currentStudio);
        }
        if (userRating != null) {
            newMovie.setUserRating(userRating);
        } else {
            newMovie.setUserRating(currentUserRating);
        }

        return newMovie;
    }
    

    public void displayRemoveMovieBanner() {
        io.print("=== Remove Movie ===");
    }
    
     public String getMovieTitleToRemove() {
        String movieTitle = io.readString("Title of movie that you would "
                + "like to remove: ");
        return movieTitle;
    }
    public void displayRemoveSuccessBanner() {
       io.print("Movie successfully removed from database.");
    }
    public void displayExitBanner() {
        io.print("Thank you! Goodbye.");
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }

   

}
