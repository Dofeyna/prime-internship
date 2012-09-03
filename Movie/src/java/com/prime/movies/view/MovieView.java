package com.prime.movies.view;

import com.prime.movies.domain.Movie;
import com.prime.movies.repository.MovieRepository;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="mv")
@ViewScoped
public class MovieView implements Serializable{
    
    private Movie movie;
    
    @EJB
    private MovieRepository movieRepository;
    private int buttonValue;

    public MovieView() {
        movie = new Movie();
    }
    
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    
    public void save() {
        movieRepository.persist(movie);
    }
    public String pageSelection( ActionEvent e){
        buttonValue = e.getID();
        
        if( buttonValue == 1) {
            return "showMovies";
        }
        else if( buttonValue == 2) {
            return "newMovie";
        }
        else if( buttonValue == 3) {
            return "editMovie";
        }
        return null;
        
   }
}
