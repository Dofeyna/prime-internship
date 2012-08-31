/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prime.movies.view;

import com.prime.movies.domain.Movie;
import com.prime.movies.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tufan Turkaslan
 */
@ManagedBean(name="mvs")
@ViewScoped
public class ListMovies {
    private List <Movie> movies;
    
    @EJB
    private MovieRepository movieRepository;
    
    public ListMovies() throws Exception{
        movies = new ArrayList<Movie>();
    }
    
    public List<Movie> getMovies(){
        movies = movieRepository.findMovies();
        return movies;
    }
    
}
