package com.prime.movies.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-08-29T11:45:35")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, Long> id;
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile SingularAttribute<Movie, Integer> year;
    public static volatile SingularAttribute<Movie, Double> rating;
    public static volatile SingularAttribute<Movie, String> director;
    public static volatile SingularAttribute<Movie, String> plot;

}