package com.stackroute.buzzup.searchservice.model;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Document annotation identifies a domain object to be persisted to MongoDB.
 */

@Document
public class Movie 
{
	
	/*
	 * This class contains 14 fields - (movieId,movieName,description,cast,language,genre,releaseDate
	 * duration,reviews,ratings,movieEvents,backgroundPoster,cardPoster,theatres).
	 * The fields movieEvents and theatres must be of List type, movieId must be of type int,
	 * ratings must be of float type, releaseDate must be of type LocalDate.
	 * This class must contain all the getters and setters along with no-arg and 
	 * parameterized constructor with toString method. 
	 */
	
	private int movieId;
	private String movieName;
	private String description;
	private String cast;
	private String language;
	private String genre;
	private LocalDate releaseDate;
	private String duration;
	private String reviews;
	private float ratings;
	private List<MovieEvents> movieEvents;
	private String backgroundPoster;
	private String cardPoster;
	private List<Theatre> theatres;
	
	public Movie() 
	{
		
	}

	public Movie(int id, String movieName, String description, String cast, String language, String genre,
			LocalDate releaseDate, String duration, String reviews, float ratings, List<MovieEvents> movieEvents,
			String backgroundPoster, String cardPoster, List<Theatre> theatres) {
		super();
		this.movieId = id;
		this.movieName = movieName;
		this.description = description;
		this.cast = cast;
		this.language = language;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.reviews = reviews;
		this.ratings = ratings;
		this.movieEvents = movieEvents;
		this.backgroundPoster = backgroundPoster;
		this.cardPoster = cardPoster;
		this.theatres = theatres;
	}

	public int getId() {
		return movieId;
	}

	public void setId(int id) {
		this.movieId = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public List<MovieEvents> getMovieEvents() {
		return movieEvents;
	}

	public void setMovieEvents(List<MovieEvents> movieEvents) {
		this.movieEvents = movieEvents;
	}

	public String getBackgroundPoster() {
		return backgroundPoster;
	}

	public void setBackgroundPoster(String backgroundPoster) {
		this.backgroundPoster = backgroundPoster;
	}

	public String getCardPoster() {
		return cardPoster;
	}

	public void setCardPoster(String cardPoster) {
		this.cardPoster = cardPoster;
	}

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}

	@Override
	public String toString() {
		return "Movie [id=" + movieId + ", movieName=" + movieName + ", description=" + description + ", cast=" + cast
				+ ", language=" + language + ", genre=" + genre + ", releaseDate=" + releaseDate + ", duration="
				+ duration + ", reviews=" + reviews + ", ratings=" + ratings + ", movieEvents=" + movieEvents
				+ ", backgroundPoster=" + backgroundPoster + ", cardPoster=" + cardPoster + ", theatres=" + theatres
				+ "]";
	}

}
