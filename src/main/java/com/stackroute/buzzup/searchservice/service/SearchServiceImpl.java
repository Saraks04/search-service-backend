package com.stackroute.buzzup.searchservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.searchservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.buzzup.searchservice.exceptions.MovieNotFoundException;
import com.stackroute.buzzup.searchservice.exceptions.TheatreAlreadyExistsException;
import com.stackroute.buzzup.searchservice.exceptions.TheatreNotFoundException;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;
import com.stackroute.buzzup.searchservice.model.Theatre;
import com.stackroute.buzzup.searchservice.repository.CitySearchRepository;
import com.stackroute.buzzup.searchservice.repository.MovieSearchRepository;
import com.stackroute.buzzup.searchservice.repository.TheatreSearchRepository;

/*
 * Annotate the class with @Service annotation which contains additional business logic to be 
 * implemented. 
 */

@Service
public class SearchServiceImpl implements SearchService
{

	private MovieSearchRepository movieRepository;
	private CitySearchRepository cityRepository;
	private TheatreSearchRepository theatreRepository;
	
	/*
	 * We use Constructor-based Autowiring for SearchService class.
	 * (No use of new keyword for creating an object)
	 */
	
	@Autowired
	public SearchServiceImpl(MovieSearchRepository movierepo, CitySearchRepository cityrepo, TheatreSearchRepository theatreRepository) 
	{
	
		this.movieRepository=movierepo;
		this.cityRepository=cityrepo;
		this.theatreRepository=theatreRepository;
		
	}
	
	/*
	 * This method is used to save a new movie.
	 */
	
	public Movie registerMovie(Movie movie) 
	{
		Movie movie1=movieRepository.insert(movie);
		return movie1;
	}
	
	/*
	 * This method is used to save a new theatre.
	 */
	
	public Theatre registerTheatre(Theatre theatre)
	{
		Theatre theatre1=theatreRepository.insert(theatre);
		return theatre1;
	}
	
	/*
	 * This method is used to update a existing movie.
	 */
	
	public Movie updateMovie(Movie movie,String movieId) throws MovieNotFoundException
	{
		
		try
		{
		  Movie fetchedmovie=movieRepository.findById(movieId).get();
		  fetchedmovie.setMovieName(movie.getMovieName());
		  fetchedmovie.setDescription(movie.getDescription());
		  fetchedmovie.setCast(movie.getCast());
		  fetchedmovie.setLanguage(movie.getLanguage());
		  fetchedmovie.setGenre(movie.getGenre());
		  fetchedmovie.setReleaseDate(movie.getReleaseDate());
		  fetchedmovie.setDuration(movie.getDuration());
		  fetchedmovie.setReviews(movie.getReviews());
		  fetchedmovie.setRatings(movie.getRatings());
		  fetchedmovie.setMovieEvents(movie.getMovieEvents());
		  fetchedmovie.setBackgroundPoster(movie.getBackgroundPoster());
		  fetchedmovie.setCardPoster(movie.getCardPoster());
		  fetchedmovie.setTheatres(movie.getTheatres());
		  
		  movieRepository.save(fetchedmovie);
		  return fetchedmovie;
		}
		catch(Exception e)
		{
			throw new MovieNotFoundException("Movie not found");
		}
		
	}
	
	
	/*
	 * This method is used to update a existing theatre.
	 */
	
	public Theatre updateTheatre(Theatre theatre,String theatreId) throws TheatreNotFoundException
	{
		
		try
		{
		  Theatre fetchedTheatre=theatreRepository.findById(theatreId).get();
		  fetchedTheatre.setTheatreName(theatre.getTheatreName());
		  fetchedTheatre.setTheatreLocation(theatre.getTheatreLocation());
		  fetchedTheatre.setCapacity(theatre.getCapacity());
		  fetchedTheatre.setUserName(theatre.getUserName());
		  fetchedTheatre.setShows(theatre.getShows());
		  
		  theatreRepository.save(fetchedTheatre);
		  return fetchedTheatre;
		}
		catch(Exception e)
		{
			throw new TheatreNotFoundException("Theatre not found");
		}
		
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
	
	/*
	 * This method should be used to get movie by MovieId and City by calling the corresponding method
	 *  of repository interface.
	 */
	
	public List<City> getMovieByMovieIdAndCity(String city,String movieId) throws MovieNotFoundException
	{
		
		List<City> movieFetched=cityRepository.findMovieByMovieIdAndCity(movieId, city);
		
		if(movieFetched != null)
			return movieFetched;
		else
			throw new MovieNotFoundException("Movie Not Found");
		
	}

}
