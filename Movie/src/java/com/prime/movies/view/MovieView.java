package com.prime.movies.view;

import com.prime.movies.domain.Movie;
import com.prime.movies.repository.MovieRepository;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tufan Turkaslan
 */

@ManagedBean(name="mv")
@ViewScoped
public class MovieView implements Serializable{
    
    private Movie movie;
    private String title, director, plot;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
    private int year;
    private Integer rating;
    
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
        this.title = movie.getTitle();
        this.director = movie.getDirector();
        this.plot = movie.getPlot();
        this.year = movie.getYear();
        this.rating = movie.getRating();
        movie = new Movie();
    }
}
