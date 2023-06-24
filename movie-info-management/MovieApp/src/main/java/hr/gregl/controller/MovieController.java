/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.controller;

import hr.gregl.dal.MovieActorDirectorRepository;
import hr.gregl.dal.MovieRepository;
import hr.gregl.dal.RepositoryFactory;
import hr.gregl.model.Movie;
import hr.gregl.model.MovieActorDirector;
import java.util.List;

/**
 *
 * @author albert
 */
public class MovieController {

    private MovieRepository movieRepository;
    private MovieActorDirectorRepository madRepository;

    public MovieController() {
        this.movieRepository = RepositoryFactory.getMovieRepository();
        this.madRepository = RepositoryFactory.getMovieActorDirectorRepository();
    }

    public void createMovie(Movie movie, List<Integer> actorIds, List<Integer> directorIds) {
        // Add the new movie to the database
        this.movieRepository.add(movie);
        int movieId = movie.getMovieID();

        // associate the actors and directors to the movie in MovieActorDirector table
        for (int actorId : actorIds) {
            for (int directorId : directorIds) {
                madRepository.add(new MovieActorDirector(movieId, actorId, directorId));
            }
        }
    }

    public void deleteMovie(int movieId) {
        this.movieRepository.delete(movieId);
    }

    public void updateMovie(Movie movie) {
        this.movieRepository.update(movie);
    }

    // better idea would be "public Optional<Movie> getMovieById(int id)"
    public Movie getMovieById(int movieId) {
        return this.movieRepository.selectById(movieId);
    }

    public List<Movie> getAllMovies() {
        return this.movieRepository.selectAll();
    }
}
