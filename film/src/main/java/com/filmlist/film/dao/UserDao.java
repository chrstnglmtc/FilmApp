package com.filmlist.film.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.filmlist.film.model.User;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }, username);
        } catch (EmptyResultDataAccessException e) {
            return null; // No user found with that username
        }
    }

    public void save(User user) {
        String sql = "INSERT INTO users (name, username, email, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getUsername(), user.getEmail(), user.getPassword());
    }
}