package com.stackroute.buzzup.searchservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Document annotation identifies a domain object to be persisted to MongoDB.
 */

@Document
public class MovieEvents 
{
	
	/*
	 * This class contains 8 fields - (movieEventId,movieId,theatreId,showCount,shows,city,
	 * userName,week).
	 * The field showCount must be of List type.
	 * This class must contain all the getters and setters along with no-arg and 
	 * parameterized constructor with toString method. 
	 */
    @Id
	private int movieEventId;
	private int movieId;
	private int theatreId;
	private int showCount;
	private List<Shows> shows;
	private String city;
	private String userName;
	private int week;
	
	public MovieEvents() 
	{
	
	}

	public MovieEvents(int movieEventId, int movieId, int theatreId, int showCount, List<Shows> shows, String city,
			String userName, int week) {
		super();
		this.movieEventId = movieEventId;
		this.movieId = movieId;
		this.theatreId = theatreId;
		this.showCount = showCount;
		this.shows = shows;
		this.city = city;
		this.userName = userName;
		this.week = week;
	}

	public int getMovieEventId() {
		return movieEventId;
	}

	public void setMovieEventId(int movieEventId) {
		this.movieEventId = movieEventId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public List<Shows> getShows() {
		return shows;
	}

	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	@Override
	public String toString() {
		return "MovieEvents [movieEventId=" + movieEventId + ", movieId=" + movieId + ", theatreId=" + theatreId
				+ ", showCount=" + showCount + ", shows=" + shows + ", city=" + city + ", userName=" + userName
				+ ", week=" + week + "]";
	}
	
	
}
