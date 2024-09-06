package com.filmlist.film.model;

public class Movie {
    
    private Long id;
    private Long userId;
    private String title;
    private String director;
    private int year;
    private String review;
    private int rating;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Movie() {
    }

    public Movie(Long id, Long userId, String title, String director, int year, String review, int rating) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.director = director;
        this.year = year;
        this.review = review;
        this.rating = rating;
    }

}
