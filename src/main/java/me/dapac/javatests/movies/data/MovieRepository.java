package me.dapac.javatests.movies.data;

import me.dapac.javatests.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findByName(String aSuper);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
