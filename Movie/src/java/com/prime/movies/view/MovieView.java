package com.prime.movies.view;

import com.prime.movies.domain.Movie;
import com.prime.movies.repository.MovieRepository;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="mv")
@ViewScoped
public class MovieView implements Serializable{
    
    private Movie movie;
    
    @EJB
    private MovieRepository movieRepository;
    private String buttonValue;


    public MovieView() {
        movie = new Movie();
        buttonValue = "showMovies.xhtml";
    }
    
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public String getButtonValue() {
        return buttonValue;
    }

    public void setButtonValue( ActionEvent e) {
        buttonValue = e.getComponent().getClientId();
        buttonValue += ".xhtml";
    }
    public void save() {
        movieRepository.persist(movie);
    }
}
