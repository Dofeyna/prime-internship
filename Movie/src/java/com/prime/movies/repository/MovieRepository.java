package com.prime.movies.repository;

import com.prime.movies.domain.Movie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MovieRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public void persist(Movie movie) {
        em.persist(movie);
    }
}
