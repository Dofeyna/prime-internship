/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prime.intern;

import com.primeInternship.movie.Movie;
import com.primeInternship.movie.MovieJpaController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tufan Turkaslan
 */
public class MovieJPAControllerTest {
    
    private MovieJpaController controller;
    
    public MovieJPAControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        controller = new MovieJpaController();
    }
    @Test
    public void shouldPersistMovie(){
        Movie m = new Movie();
        m.setTitle("Matrix");
        controller.create(m);
        
        assertNotNull("ID should not be null", m.getId());
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
