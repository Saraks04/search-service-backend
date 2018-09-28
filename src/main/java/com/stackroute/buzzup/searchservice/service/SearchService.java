package com.stackroute.buzzup.searchservice.service;

import java.util.List;

import com.stackroute.buzzup.searchservice.exceptions.MovieNotFoundException;
import com.stackroute.buzzup.searchservice.exceptions.TheatreNotFoundException;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;
import com.stackroute.buzzup.searchservice.model.Theatre;

public interface SearchService 
{

	/*
	 * SearchService interface contains the methods to be implemented in Implementation classes.
	 */
	
	public Movie registerMovie(Movie movie); 
	public Theatre registerTheatre(Theatre theatre); 
	public Movie updateMovie(Movie movie,String movieId) throws MovieNotFoundException;
	public Theatre updateTheatre(Theatre theatre,String theatreId) throws TheatreNotFoundException;
	public List<Movie> getMovieByMovieName(String movieName) throws MovieNotFoundException;
	public List<City> getMovieByCity(String city) throws MovieNotFoundException;
	public List<City> getMovieByMovieIdAndCity(String city,String movieId) throws MovieNotFoundException;
	
}
