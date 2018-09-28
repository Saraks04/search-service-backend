package com.stackroute.buzzup.searchservice.repository;

import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.searchservice.model.Movie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * Annotate this class with @Repository, which implements the MongoRepository interface for City class. 
 */

@Repository
public interface MovieSearchRepository extends MongoRepository<Movie,String> 
{

	/*
	 * Creating new method findAllByMovieName in Mongo Repository for retrieving all movie details 
	 * from  mongoDb based on movieName. 
	 */
	
	List<Movie> findAllByMovieName(String movieName);

	
}
