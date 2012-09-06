package com.prime.movies.repository;

import com.prime.movies.domain.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MovieRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public void persist(Movie movie) {
        em.persist(movie);
    }
    public void delete (Movie movie) {
        Movie m = em.merge (movie);
        em.remove( m );
    }

    public void update (Movie movie) {
      em.merge (movie);
    }
    public List <Movie> findMovies () {
      return (List <Movie>) em.createQuery("select m from Movie m").getResultList();
    }
}
