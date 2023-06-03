/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.model;

/**
 *
 * @author albert
 */
public final class Movie {

    private int movieId;
    private String title;
    private String genre;
    private int releaseYear;
    private String imagePath;

    public Movie() {
    }

    public Movie(String title, String genre, int releaseYear, String imagePath) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.imagePath = imagePath;
    }

    public Movie(int movieID, String title, String genre, int releaseYear, String imagePath) {
        this(title, genre, releaseYear, imagePath);
        this.movieId = movieID;
    }

    public int getMovieID() {
        return movieId;
    }

    public void setMovieID(int movieID) {
        this.movieId = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return movieId + " - " + title + " - " + genre + " - " + releaseYear;
    }
}
