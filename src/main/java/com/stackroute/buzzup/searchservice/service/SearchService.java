package com.stackroute.buzzup.searchservice.service;

import java.util.List;

import com.stackroute.buzzup.searchservice.exceptions.MovieNotFoundException;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;

public interface SearchService 
{

	/*
	 * SearchService interface contains the methods to be implemented in Implementation classes.
	 */
	
	List<Movie> getMovieByMovieName(String movieName) throws MovieNotFoundException;
	List<City> getMovieByCity(String city) throws MovieNotFoundException;
	
}
