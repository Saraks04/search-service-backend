package com.stackroute.buzzup.searchservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.searchservice.model.Theatre;

/*
 * Annotate this class with @Repository, which implements the MongoRepository interface for City class. 
 */

@Repository
public interface TheatreSearchRepository extends MongoRepository<Theatre,String>
{

}
