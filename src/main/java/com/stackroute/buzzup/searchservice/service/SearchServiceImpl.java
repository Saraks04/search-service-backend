package com.stackroute.buzzup.searchservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.searchservice.exceptions.MovieNotFoundException;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;
import com.stackroute.buzzup.searchservice.repository.CitySearchRepository;
import com.stackroute.buzzup.searchservice.repository.MovieSearchRepository;

/*
 * Annotate the class with @Service annotation which contains additional business logic to be 
 * implemented. 
 */

@Service
public class SearchServiceImpl implements SearchService
{

	private MovieSearchRepository movieRepository;
	private CitySearchRepository cityRepository;
	
	/*
	 * We use Constructor-based Autowiring for SearchService class.
	 * (No use of new keyword for creating an object)
	 */
	
	@Autowired
	public SearchServiceImpl(MovieSearchRepository movierepo, CitySearchRepository cityrepo) 
	{
	
		this.movieRepository=movierepo;
		this.cityRepository=cityrepo;
		
	}
	
	/*
	 * This method should be used to get movie by movieName by calling the corresponding method of 
	 * repository interface.
	 */
	
	
	public List<Movie> getMovieByMovieName(String movieName) throws MovieNotFoundException
	{
		
		List<Movie> movieFetched=movieRepository.findAllByMovieName(movieName);
		
		if(movieFetched !=null)
			return movieFetched;
		
		else
			throw new MovieNotFoundException("Movie not found");
	}
	
	/*
	 * This method should be used to get movie by city by calling the corresponding method of 
	 * repository interface.
	 */
	
	public List<City> getMovieByCity(String city) throws MovieNotFoundException
	{
		
		List<City> movieFetched=cityRepository.findAllMoviesByCity(city);
		
		if(movieFetched != null)
			return movieFetched;
		
		else
			throw new MovieNotFoundException("Movie not casted in the city");
	}
}
