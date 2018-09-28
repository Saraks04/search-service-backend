package com.stackroute.buzzup.searchservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.searchservice.model.City;

/*
 * Annotate this class with @Repository, which implements the MongoRepository interface for City class. 
 */

@Repository
public interface CitySearchRepository extends MongoRepository<City,String> 
{
	/*
	 * Creating new method findAllMoviesByCity in Mongo Repository for retrieving all movie details 
	 * from  mongoDb based on city. 
	 */
	
	List<City> findAllMoviesByCity(String city);

}
