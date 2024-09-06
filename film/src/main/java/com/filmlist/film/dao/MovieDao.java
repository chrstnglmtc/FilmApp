package com.filmlist.film.dao;

import com.filmlist.film.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movie> findByUserId(Long userId) {
        String sql = "SELECT * FROM movies WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Movie.class));
    }

    public void save(Movie movie) {
        String sql = "INSERT INTO movies (user_id, title, director, year, review, rating) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, movie.getUserId(), movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getReview(), movie.getRating());
    }

    public void update(Movie movie) {
        String sql = "UPDATE movies SET title = ?, director = ?, year = ?, review = ?, rating = ? WHERE id = ?";
        jdbcTemplate.update(sql, movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getReview(), movie.getRating(), movie.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM movies WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
