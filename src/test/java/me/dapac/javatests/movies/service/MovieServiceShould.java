package me.dapac.javatests.movies.service;

import me.dapac.javatests.movies.data.MovieRepository;
import me.dapac.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static me.dapac.javatests.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "There's Something About Mary", 119, COMEDY),
                        new Movie(4, "Super 8", 112, THRILLER),
                        new Movie(5, "Scream", 111, HORROR),
                        new Movie(6, "Home Alone", 103, COMEDY),
                        new Movie(7, "Matrix", 136, ACTION)
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMovieByGenre(COMEDY);
        assertThat(getMovieId(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMovieByLength(119);
        assertThat(getMovieId(movies), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    private List<Integer> getMovieId(Collection<Movie> movies) {
        return movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
    }
}