package me.dapac.javatests.movies.data;

import me.dapac.javatests.movies.model.Genre;
import me.dapac.javatests.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        //Create a test database connection in ram memory with MySQL format
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        //Execute a script to create the movies table
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        //Create a jdbc template
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //Get movies from database
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION),
                new Movie(4, "Superman", 87, Genre.ACTION)
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @Test
    public void load_movie_by_name() {
        Collection<Movie> movies = movieRepository.findByName("Super");
        assertThat(movies, is(Arrays.asList(
                new Movie(4, "Superman", 87, Genre.ACTION)
        )));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);
        movieRepository.saveOrUpdate(movie);
        Movie movieFromDb = movieRepository.findById(5);
        assertThat(movieFromDb, is(new Movie(5, "Super 8", 112, Genre.THRILLER)));
    }

    @After
    public void tearDown() throws Exception {
        // Remove H2 files
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); //"shutdown" is also enough for men db
    }
}