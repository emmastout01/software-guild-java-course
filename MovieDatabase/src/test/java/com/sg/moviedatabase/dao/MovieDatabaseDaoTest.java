/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.moviedatabase.dao;

import com.sg.moviedatabase.dto.Movie;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emmastout
 */
public class MovieDatabaseDaoTest {

    MovieDatabaseDao dao = new MovieDatabaseDaoFileImpl();

    public MovieDatabaseDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        //Before each method, we want to empty the list of movies
        //so we will be working with an empty data set:

        List<Movie> movieList = dao.getAllMovies();

        for (Movie movie : movieList) {
            dao.removeMovie(movie.getTitle());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllMovies method, of class MovieDatabaseDao.
     */
    @Test
    public void testGetAllMovies() throws Exception {
        Movie movie1 = new Movie("Muppet Treasure Island");
//        movie1.setReleaseDate("1998");
        movie1.setDirectorName("Jim Henson");
        movie1.setMpaaRating("PG");
        movie1.setUserRating("Two thumbs up!");
        movie1.setStudio("Jim Henson Productions");

        dao.addMovie(movie1.getTitle(), movie1);

        Movie movie2 = new Movie("Labyrinth");
//        movie2.setReleaseDate("1986");
        movie2.setDirectorName("Jim Henson");
        movie2.setMpaaRating("PG");
        movie2.setUserRating("You remind me of the babe");
        movie2.setStudio("Jim Henson Productions");

        dao.addMovie(movie2.getTitle(), movie2);

        assertEquals(2, dao.getAllMovies().size());
    }

    /**
     * Test of addMovie method, of class MovieDatabaseDao.
     */
    @Test
    public void testAddGetMovie() throws Exception {
        Movie movie = new Movie("Muppet Treasure Island");
//        movie.setReleaseDate("1998");
        movie.setDirectorName("Jim Henson");
        movie.setMpaaRating("PG");
        movie.setUserRating("Two thumbs up!");
        movie.setStudio("Jim Henson Productions");

        dao.addMovie(movie.getTitle(), movie);

        Movie daoMovie = dao.viewMovie(movie.getTitle());

        assertEquals(movie, daoMovie);
    }

    /**
     * Test of editMovie method, of class MovieDatabaseDao.
     */
    @Test
    public void testEditMovie() throws Exception {
        //Add a movie to the file
        Movie movie1 = new Movie("Muppet Treasure Island");
//        movie1.setReleaseDate("1998");
        movie1.setDirectorName("Jim Henson");
        movie1.setMpaaRating("PG");
        movie1.setUserRating("Two thumbs up!");
        movie1.setStudio("Jim Henson Productions");

        dao.addMovie(movie1.getTitle(), movie1);
        
        //Get the movie from the file
        Movie uneditedMovie = dao.viewMovie(movie1.getTitle());
        
        //Edit fields and save
        movie1.setDirectorName("Julius Caesar");
        dao.editMovie(movie1.getTitle(), movie1);
        
        //Get the movie again, and confirm that the new fields look the way I expect them to
        Movie editedMovie = dao.viewMovie(movie1.getTitle());
        
        assertEquals("Julius Caesar", 
                dao.viewMovie(movie1.getTitle()).getDirectorName());
    }

    /**
     * Test of removeMovie method, of class MovieDatabaseDao.
     */
    @Test
    public void testRemoveMovie() throws Exception {

        Movie movie1 = new Movie("Muppet Treasure Island");
//        movie1.setReleaseDate("1998");
        movie1.setDirectorName("Jim Henson");
        movie1.setMpaaRating("PG");
        movie1.setUserRating("Two thumbs up!");
        movie1.setStudio("Jim Henson Productions");

        dao.addMovie(movie1.getTitle(), movie1);

        Movie movie2 = new Movie("Labyrinth");
//        movie2.setReleaseDate("1986");
        movie2.setDirectorName("Jim Henson");
        movie2.setMpaaRating("PG");
        movie2.setUserRating("You remind me of the babe");
        movie2.setStudio("Jim Henson Productions");

        dao.addMovie(movie2.getTitle(), movie2);

        dao.removeMovie(movie1.getTitle());

        assertEquals(1, dao.getAllMovies().size());
        assertNull(dao.viewMovie(movie1.getTitle()));

        dao.removeMovie(movie2.getTitle());

        assertEquals(0, dao.getAllMovies().size());
        assertNull(dao.viewMovie(movie2.getTitle()));
    }

    /**
     * Test of searchMovies method, of class MovieDatabaseDao.
     */
    @Test
    public void testSearchMovies() throws Exception {
        //First add 2 movies: 'Land Before Time" and "Labyrinth"
        Movie movie1 = new Movie("Land Before Time");
//        movie1.setReleaseDate("1994");
        movie1.setDirectorName("");
        movie1.setMpaaRating("G");
        movie1.setUserRating("A classic for all time!");
        movie1.setStudio("Fox Searchlight");

        dao.addMovie(movie1.getTitle(), movie1);

        Movie movie2 = new Movie("Labyrinth");
//        movie2.setReleaseDate("1986");
        movie2.setDirectorName("Jim Henson");
        movie2.setMpaaRating("PG");
        movie2.setUserRating("You remind me of the babe");
        movie2.setStudio("Jim Henson Productions");

        dao.addMovie(movie2.getTitle(), movie2);
        
        //Check if dao.searchMovies("La").size() is 2
        assertEquals(2, dao.searchMovies("La").size());

        //Check if dao.searchMovies("Lab").size() is 1
        assertEquals(1, dao.searchMovies("Lab").size());
       
        //Check if dao.searchMovies("M").size() is 0
        assertEquals(0, dao.searchMovies("M").size());
    }

}
