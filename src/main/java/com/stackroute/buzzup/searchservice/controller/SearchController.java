package com.stackroute.buzzup.searchservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.searchservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.buzzup.searchservice.exceptions.MovieNotFoundException;
import com.stackroute.buzzup.searchservice.exceptions.TheatreAlreadyExistsException;
import com.stackroute.buzzup.searchservice.exceptions.TheatreNotFoundException;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;
import com.stackroute.buzzup.searchservice.model.Theatre;
import com.stackroute.buzzup.searchservice.service.SearchService;

/*
 *As we are working with Restful services,we annotate this class with @RestController.
 *If we use @ResponseBody annotation along with @Controller annotation, it will return the data 
 *directly in a serialized format since @RestController annotation is equivalent to using @Controller 
 *and @ResponseBody.
 */

@RestController
@CrossOrigin("*")
public class SearchController 
{

private SearchService searchService;
	
	/*
	 * We use Constructor-based Autowiring for SearchController class.
	 * (No use of new keyword for creating an object)
	 */

	@Autowired
	public SearchController(SearchService searchService) 
	{
		this.searchService=searchService;
	}
	
	/*
	 * The below handler method is mapped to the URL "/api/v1/movie" inorder to save the movie details.
	 * It must return any one of the status messages based on the the retrieved result:
	 * 1.201(CREATED) - If the movie is found      
	 * 2.409(CONFLICT) - If the movie does not exist in the database.   
	 */
	
	@PostMapping("/api/v1/movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie)throws MovieAlreadyExistsException
	{
        
		try
        {
            searchService.saveMovie(movie);
            return new ResponseEntity<Movie>(movie,HttpStatus.CREATED);
            
        }
        
		catch(Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
	
	/*
	 * The below handler method is mapped to the URL "/api/v1/theatre" inorder to save the theatre details.
	 * It must return any one of the status messages based on the the retrieved result:
	 * 1.201(CREATED) - If the movie is found      
	 * 2.409(CONFLICT) - If the movie does not exist in the database.   
	 */
	
	@PostMapping("/api/v1/theatre")
    public ResponseEntity<?> saveTheatre(@RequestBody Theatre theatre)throws TheatreAlreadyExistsException
	{
        
		try
        {
            searchService.saveTheatre(theatre);
            return new ResponseEntity<Theatre>(theatre,HttpStatus.CREATED);
            
        }
		
		catch(Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
	}
	
	/*
	 * The below handler method is mapped to the URL "/api/v1/movie/{movieId}" inorder to update 
	 * the movie details. It must return any one of the status messages based on the the retrieved 
	 * result:   1.200(OK) - If the movie is found      
	 * 			 2.404(NOT_FOUND) - If the movie does not exist in the database.   
	 */
	
	@PutMapping("/api/v1/movie/{movieId}")
	public ResponseEntity<?>updateMovie(@PathVariable() String movieId, @RequestBody Movie movie) throws MovieNotFoundException
	{

	   ResponseEntity<?>responseEntity = null;

	   try 
	   {
	      Movie fetchedMovie = searchService.updateMovie(movie,movieId);
	      responseEntity = new ResponseEntity<>(fetchedMovie, HttpStatus.OK);
	   } 
	   
	   catch (MovieNotFoundException exception) 
	   {

	      responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	   }

	  return responseEntity;
	}
	
	/*
	 * The below handler method is mapped to the URL "/api/v1/theatre/{theatreId}" inorder to update 
	 * the theatre details. It must return any one of the status messages based on the the retrieved 
	 * result:   1.200(OK) - If the movie is found      
	 * 			 2.404(NOT_FOUND) - If the movie does not exist in the database.   
	 */
	
	@PutMapping("/api/v1/theatre/{theatreId}")
	public ResponseEntity<?>updateTheatre(@PathVariable() String theatreId, @RequestBody Theatre theatre) throws TheatreNotFoundException
	{

	   ResponseEntity<?>responseEntity = null;

	   try 
	   {
	      Theatre fetchedTheatre = searchService.updateTheatre(theatre, theatreId);
	      responseEntity = new ResponseEntity<>(fetchedTheatre, HttpStatus.OK);
	   } 
	   
	   catch (TheatreNotFoundException exception) 
	   {

	      responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

	   }

	  return responseEntity;
	}
	
	/*
	 * The below handler method is mapped to the URL "/api/v1/movie/{movieName}" inorder
	 * to get all movie details by a particular movie name.
	 * It must return any one of the status messages based on the the retrieved result:
	 * 1.200(OK) - If the movie is found      
	 * 2.404(NOt_FOUND) - If the movie does not exist in the database.   
	 */
	
	@GetMapping("/api/v1/movie/{movieName}")
	public ResponseEntity<?> getMovieByName (@PathVariable String movieName) throws MovieNotFoundException
	{
		try
		{
			List<Movie> getMovie=searchService.getMovieByMovieName(movieName);
			if(getMovie==null)
				return new ResponseEntity<String>("Movie not found",HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<List<Movie>>(getMovie,HttpStatus.OK);
				
		}
		catch(MovieNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * The below handler method is mapped to the URL "/api/v1/city/{city}" inorder
	 * to get all movie details by a particular city name.
	 * It must return any one of the status messages based on the the retrieved result:
	 * 1.200(OK) - If the movie is found      
	 * 2.404(NOt_FOUND) - If the movie does not exist in the database.   
	 */
	
	@GetMapping("/api/v1/city/{city}")
	public ResponseEntity<?> getMovieByCity (@PathVariable String city) throws MovieNotFoundException
	{
		try
		{
			List<City> getMovie=searchService.getMovieByCity(city);
			if(getMovie==null)
				return new ResponseEntity<String>("Movie not found",HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<List<City>>(getMovie,HttpStatus.OK);
				
		}
		catch(MovieNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * The below handler method is mapped to the URL "/api/v1/city/{city}" inorder
	 * to get all movie details by a particular movieId and city.
	 * It must return any one of the status messages based on the the retrieved result:
	 * 1.200(OK) - If the movie is found      
	 * 2.404(NOt_FOUND) - If the movie does not exist in the database.   
	 */
	
	@GetMapping("/api/v1/city/{city}")
	public ResponseEntity<?> getMovieByMovieIdAndCity (@PathVariable String city,@PathVariable String movieId) throws MovieNotFoundException
	{
		try
		{
			List<City> getMovie=searchService.getMovieByMovieIdAndCity(city, movieId);
			if(getMovie==null)
				return new ResponseEntity<String>("Movie not found",HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<List<City>>(getMovie,HttpStatus.OK);
				
		}
		catch(MovieNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
