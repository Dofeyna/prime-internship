/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primeInternship.movie;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MovieJpaController implements Serializable{
    

    private EntityManagerFactory emf = null;

    public MovieJpaController() {
        emf = Persistence.createEntityManagerFactory("MoviePU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   
    public void create(Movie movie) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
            em.close();
            }
        }
    }
    
    public void edit(Movie movie) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movie = em.merge(movie);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            ex.printStackTrace();
        } finally {
            if (em != null) {
               em.close();
            }
        }
    }
    public void destroy(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movie movie;
            try {
                movie = em.getReference(Movie.class, id);
                em.remove(movie);
            } catch (EntityNotFoundException enfe) {
               enfe.printStackTrace();
            }
            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
            em.close();
            }
        }
    }
    public List<Movie> findMovieEntities() {
        return findMovieEntities(true, -1, -1);
    }
    public List<Movie> findMovieEntities(int maxResults,int firstResult) {
        return findMovieEntities(false, maxResults, firstResult);
    }
    private List<Movie> findMovieEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movie.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    public Movie findMovie(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movie.class, id);
        } finally {
            em.close();
        }
    }
    public int getMovieCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movie> rt = cq.from(Movie.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
