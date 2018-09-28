package com.stackroute.buzzup.searchservice.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Document annotation identifies a domain object to be persisted to MongoDB.
 */

@Document
public class Shows 
{
	
	/*
	 * This class contains 7 fields - (showId,showTime,ticketPrice,seatsRemaining,date,
	 * movieId,status).
	 
	 * The fields ticketPrice,seatsRemaining and movieId must be of List int, showTime must 
	 * be of type LocalTime and status must be of type boolean.
	 
	 * This class must contain all the getters and setters along with no-arg and parameterized 
	 * constructor with toString method. 
	 */

	@Id
	private String showId;
	private LocalTime showTime;
	private int ticketPrice;
	private int seatsRemaining;
	private LocalDate date;
	private int movieId;
	private boolean status;
	
	public Shows() 
	{
		
	}

	public Shows(String showId, LocalTime showTime, int ticketPrice, int seatsRemaining, LocalDate date, int movieId,
			boolean status) {
		super();
		this.showId = showId;
		this.showTime = showTime;
		this.ticketPrice = ticketPrice;
		this.seatsRemaining = seatsRemaining;
		this.date = date;
		this.movieId = movieId;
		this.status = status;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public LocalTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getSeatsRemaining() {
		return seatsRemaining;
	}

	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", showTime=" + showTime + ", ticketPrice=" + ticketPrice
				+ ", seatsRemaining=" + seatsRemaining + ", date=" + date + ", movieId=" + movieId + ", status="
				+ status + "]";
	}
	
}
