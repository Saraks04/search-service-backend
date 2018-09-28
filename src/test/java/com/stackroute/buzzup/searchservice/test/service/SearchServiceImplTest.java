package com.stackroute.buzzup.searchservice.test.service;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.buzzup.searchservice.exceptions.MovieNotFoundException;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;

import com.stackroute.buzzup.searchservice.model.Theatre;
import com.stackroute.buzzup.searchservice.repository.MovieSearchRepository;
import com.stackroute.buzzup.searchservice.repository.CitySearchRepository;
import com.stackroute.buzzup.searchservice.service.SearchServiceImpl;


public class SearchServiceImplTest {


    private City city;
    private Movie movie;

    @Mock
    private MovieSearchRepository movierepository;
    private CitySearchRepository cityrepository;
    @InjectMocks
    private SearchServiceImpl searchServiceImpl;
    private List<Movie> movieList;
    private List<City> city1;
    private List<Theatre> theatreList;
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        Movie movie = new Movie();
        movie.setId(2);
        movie.setMovieName("incidious");
        movie.setBackgroundPoster("src/images/im1.jpg");
        movie.setCardPoster("src/images/im2.jpg");
        movie.setDescription("horror");
        movie.setLanguage("english");
        
         City city=new City();
         city.setCity("bangalore");
         city.setMovieList(movieList);
         city.setTheatreList(theatreList);
 
        
         movieList = new ArrayList<>();
    }

    @Test(expected=NullPointerException.class)
    public void getMovieByMovieNameTest() throws Exception {
     
    	when(movierepository.findAllByMovieName(movie.getMovieName())).thenReturn(movieList);
        List<Movie> fetchedMovie = searchServiceImpl.getMovieByMovieName("Jak De India");

        assertEquals(movie, fetchedMovie);

    }
    @Test(expected=NullPointerException.class)
    public void getMovieByCityTest() throws MovieNotFoundException {

    	when(cityrepository.findAllMoviesByCity(city.getCity())).thenReturn(city1);

        List<City> fetchedMovie = searchServiceImpl.getMovieByCity("Bangalore");

        assertEquals(city, fetchedMovie);
    }
    }
  