package com.filmlist.film.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmlist.film.dao.MovieDao;
import com.filmlist.film.model.Movie;

@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    public List<Movie> getMoviesByUserId(Long userId) {
        return movieDao.findByUserId(userId);
    }

    public void addMovie(Movie movie) {
        movieDao.save(movie);
    }

    public void updateMovie(Movie movie) {
        movieDao.update(movie);
    }

    public void deleteMovie(Long movieId) {
        movieDao.delete(movieId);
    }
}
