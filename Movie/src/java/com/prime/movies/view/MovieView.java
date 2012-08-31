package com.prime.movies.view;

import com.prime.movies.domain.Movie;
import com.prime.movies.repository.MovieRepository;
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
}
