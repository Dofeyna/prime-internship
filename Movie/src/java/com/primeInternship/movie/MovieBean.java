/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primeInternship.movie;

/**
 *
 * @author Tufan Turkaslan
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MovieBean {
    private Movie movie = new Movie();
    private MovieJpaController controller;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public void save(){
        Movie m = new Movie();
        m = movie;
        controller.create(m);
    }
}
