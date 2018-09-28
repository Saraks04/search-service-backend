package com.stackroute.buzzup.searchservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Document annotation identifies a domain object to be persisted to MongoDB.
 */

@Document
public class Theatre 
{
	
	/*
	 * This class contains 6 fields - (theatreID,theatreName,theatreLocation,capacity,userName,shows).
	 * The field shows must be of List type and capacity must be of type int.
	 * This class must contain all the getters and setters along with no-arg and 
	 * parameterized constructor with toString method. 
	 */
     @Id
	 private String theatreId;
	 private String theatreName;
	 private String theatreLocation;
	 private int capacity;
	 private String userName;
	 private List<Shows> shows;
	 
	 public Theatre() 
	 {
		
	 }

	public Theatre(String theatreId, String theatreName, String theatreLocation, int capacity, String userName,
			List<Shows> shows) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.capacity = capacity;
		this.userName = userName;
		this.shows = shows;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreLocation() {
		return theatreLocation;
	}

	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Shows> getShows() {
		return shows;
	}

	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + ", capacity=" + capacity + ", userName=" + userName + ", shows=" + shows + "]";
	}

}
