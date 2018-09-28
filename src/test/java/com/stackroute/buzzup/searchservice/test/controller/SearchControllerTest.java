package com.stackroute.buzzup.searchservice.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.searchservice.controller.SearchController;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;
import com.stackroute.buzzup.searchservice.model.Theatre;
import com.stackroute.buzzup.searchservice.service.SearchService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertNotNull;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest


public class SearchControllerTest 
{
	
	    private Movie movie;
	    @Autowired
	    private MockMvc mockMvc;
	    @MockBean
	    private City city;
	    @MockBean
	    SearchService searchService;
	    @InjectMocks
	    SearchController searchController;
	    
	    private List<Movie> movieList;
	    private List<City> city1;
	    private List<Theatre> theatreList;
	    
	    @Before
	    public void setUp()
	    {
	    	MockitoAnnotations.initMocks(this);
	    	mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
		    movie = new Movie();
	        movie.setId(2);
	        movie.setMovieName("incidious");
	        movie.setBackgroundPoster("src/images/im1.jpg");
	        movie.setCardPoster("src/images/im2.jpg");
	        movie.setDescription("horror");
	        movie.setLanguage("english");
	        
	         city=new City();
	         city.setCity("bangalore");
	         city.setMovieList(movieList);
	         city.setTheatreList(theatreList);
	    }

	    @Test
	    public void getMovieByMovieNameTest() throws Exception 
	    {
	        when(searchService.getMovieByMovieName("incidious")).thenReturn(movieList);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/incidious").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(movie))).andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());
	        assertNotNull("abc");
	        
	    }
	    
	    @Test
	    public void getMovieByCityTest() throws Exception 
	    {
	        when(searchService.getMovieByCity("bangalore")).thenReturn(city1);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/city/bangalore").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(city))).andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());
	        assertNotNull("abc");
	        
	    }
	    
	    public static String asJsonString(final Object obj) 
	    {
	        try 
	        {
	            return new ObjectMapper().writeValueAsString(obj);
	        } 
	        catch (Exception e) 
	        {
	            throw new JsonParseException(e);
	        }
	    }
	    
	    
}

