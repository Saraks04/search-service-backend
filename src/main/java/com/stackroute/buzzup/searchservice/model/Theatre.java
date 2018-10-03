package com.stackroute.buzzup.searchservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Theatre {
	@Id
	private String theatreId;
	private String theatreName;
	private String theatreLocation;
	private Seats seatLayout;
	private int showNumbers;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String[] showTimings;
	private int[] weekendsPrice;
	private int[] weekdaysPrice;
	private String[] screenedmovies;
	private String[] runningmovies;
	private String[] typesOfSeats;
	private int[] numberOfSeats;

	public Theatre(String theatreId, String theatreName, String theatreLocation, Seats seatLayout, int showNumbers,
			String[] showTimings, int[] weekendsPrice, int[] weekdaysPrice, String[] screenedmovies,
			String[] runningmovies, String[] typesOfSeats, int[] numberOfSeats) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.seatLayout = seatLayout;
		this.showNumbers = showNumbers;
		this.showTimings = showTimings;
		this.weekendsPrice = weekendsPrice;
		this.weekdaysPrice = weekdaysPrice;
		this.screenedmovies = screenedmovies;
		this.runningmovies = runningmovies;
		this.typesOfSeats = typesOfSeats;
		this.numberOfSeats = numberOfSeats;
	}

	public Theatre() {
		super();
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

	public Seats getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(Seats seatLayout) {
		this.seatLayout = seatLayout;
	}

	public int getShowNumbers() {
		return showNumbers;
	}

	public void setShowNumbers(int showNumbers) {
		this.showNumbers = showNumbers;
	}

	public String[] getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(String[] showTimings) {
		this.showTimings = showTimings;
	}

	public int[] getWeekendsPrice() {
		return weekendsPrice;
	}

	public void setWeekendsPrice(int[] weekendsPrice) {
		this.weekendsPrice = weekendsPrice;
	}

	public int[] getWeekdaysPrice() {
		return weekdaysPrice;
	}

	public void setWeekdaysPrice(int[] weekdaysPrice) {
		this.weekdaysPrice = weekdaysPrice;
	}

	public String[] getScreenedmovies() {
		return screenedmovies;
	}

	public void setScreenedmovies(String[] screenedmovies) {
		this.screenedmovies = screenedmovies;
	}

	public String[] getRunningmovies() {
		return runningmovies;
	}

	public void setRunningmovies(String[] runningmovies) {
		this.runningmovies = runningmovies;
	}

	public String[] getTypesOfSeats() {
		return typesOfSeats;
	}

	public void setTypesOfSeats(String[] typesOfSeats) {
		this.typesOfSeats = typesOfSeats;
	}

	public int[] getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int[] numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

}
