package com.stackroute.buzzup.searchservice.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Document annotation identifies a domain object to be persisted to MongoDB.
 */

@Document
public class City 
{

	/*
	 * This class contains 3 fields - (city,movieList,theatreList).
	 * The fields movieList and theatreList must be of List type.
	 * This class must contain all the getters and setters along with no-arg and 
	 * parameterized constructor with toString method. 
	 */
	
	private String city;
	private List<Movie> movieList;
	private List<Theatre> theatreList;
	
	public City()
	{
		
	}

	public City(String city, List<Movie> movieList, List<Theatre> theatreList) {
		super();
		this.city = city;
		this.movieList = movieList;
		this.theatreList = theatreList;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public List<Theatre> getTheatreList() {
		return theatreList;
	}

	public void setTheatreList(List<Theatre> theatreList) {
		this.theatreList = theatreList;
	}

	@Override
	public String toString() {
		return "City [city=" + city + ", movieList=" + movieList + ", theatreList=" + theatreList + "]";
	}
	
}
