package com.filmlist.film.dao;

import com.filmlist.film.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movie> findByUserId(Long userId) {
        String sql = "SELECT * FROM movies WHERE user_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Movie movie = new Movie();
            movie.setId(rs.getLong("id"));
            movie.setTitle(rs.getString("title"));
            movie.setDirector(rs.getString("director"));
            movie.setYear(rs.getInt("year"));
            movie.setReview(rs.getString("review"));
            movie.setRating(rs.getInt("rating"));
            movie.setUserId(rs.getLong("user_id"));
            return movie;
        }, userId);
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
