/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.ui;

import com.sg.moviedatabase.dto.Movie;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        io.print("4. Search for a movie by title");
        io.print("5. Edit movie information");
        io.print("6. Remove movie from database by title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
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
        String releaseDate = io.readString("Release Date (mm/dd/yyyy):");
        String rating = io.readString("MPAA Rating:");
        String director = io.readString("Director:");
        String studio = io.readString("Studio:");
        String userRating = io.readString("Your movie rating/comments:");
        
        LocalDate convertedReleaseDate = convertReleaseDate(releaseDate);

        Movie newMovie = new Movie(title);
        newMovie.setReleaseDate(convertedReleaseDate);
        newMovie.setMpaaRating(rating);
        newMovie.setDirectorName(director);
        newMovie.setStudio(studio);
        newMovie.setUserRating(userRating);

        return newMovie;
    }
    
    public LocalDate convertReleaseDate(String stringReleaseDate) {
        return LocalDate.parse(stringReleaseDate, 
                DateTimeFormatter.ofPattern("MM/dd/yyyy"));
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
    
     public String getSearch() {
        String movieTitle = io.readString("Search for movies that start with: ");
        return movieTitle;
    }

    public void displayMovie(Movie movie) {
        
        if (movie != null) {
            io.print(movie.getTitle());
            io.print(movie.getReleaseDate().toString());
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
        LocalDate currentRelease = currentMovie.getReleaseDate();
        String currentRating = currentMovie.getMpaaRating();
        String currentDirector = currentMovie.getDirectorName();
        String currentStudio = currentMovie.getStudio();
        String currentUserRating = currentMovie.getUserRating();
                
        
        String title = io.readStringPrintf("Movie title (%s):", currentTitle);
        String releaseDate = io.readStringPrintf("Release Date (mm/dd/yyyy) (%s):", 
                currentRelease.toString());
        String rating = io.readStringPrintf("MPAA Rating (%s):", currentRating);
        String director = io.readStringPrintf("Director (%s):", currentDirector);
        String studio = io.readStringPrintf("Studio (%s):", currentStudio);
        String userRating = io.readStringPrintf
        ("Your movie rating/comments (%s):", currentUserRating);

        
        Movie newMovie;
        
        if(!title.isEmpty()) {
            newMovie = new Movie(title);
        } else {
            newMovie = new Movie(currentTitle);
        }
        if(!releaseDate.isEmpty()) {
           LocalDate convertedReleaseDate = convertReleaseDate(releaseDate);
           newMovie.setReleaseDate(convertedReleaseDate); 
        } else {
            newMovie.setReleaseDate(currentRelease);
        } 
        if (!rating.isEmpty()) {
          newMovie.setMpaaRating(rating);  
        } else {
           newMovie.setMpaaRating(currentRating);  
        }
        if (!director.isEmpty()) {
            newMovie.setDirectorName(director);
        } else {
            newMovie.setDirectorName(currentDirector);
        }
        if (!studio.isEmpty()) {
            newMovie.setStudio(studio);
        } else {
            newMovie.setStudio(currentStudio);
        }
        if (!userRating.isEmpty()) {
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
    
    public void displayRemoveFail(String movieTitle) {
        io.print("Error: " + movieTitle + " could not be removed.");
    }
   
    public void displayExitBanner() {
        io.print("Thank you! Goodbye.");
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }

    public void displayEditSuccess(String movieTitle) {
        io.print(movieTitle + "was successfully edited!");
    }

    public void displayEditFail(String movieTitle) {
        io.print("Error: " + movieTitle + " could not be edited.");
    }

    public void displaySearchBanner() {
        io.print("=== Search Movies ===");
    }

    public void displayNoMovieBanner() {
        io.print("No such movie exists in the database.");
    }

   

}
