package com.filmlist.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmlist.film.model.Movie;
import com.filmlist.film.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/users/{userId}")
    public List<Movie> getMoviesByUserId(@PathVariable Long userId) {
        return movieService.getMoviesByUserId(userId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateMovie(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
