package com.primeInternship.controller;


import com.primeInternship.movie.Movie;
import com.primeInternship.movie.MovieJpaController;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.*;
import org.primefaces.context.RequestContext;

@ManagedBean(name="mb")
@SessionScoped
public class MovieBean implements Serializable{
    Movie movie = new Movie();
    private MovieJpaController controller;
        
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public void save() {
        controller = new MovieJpaController();
        controller.create(movie);     
    }
}
