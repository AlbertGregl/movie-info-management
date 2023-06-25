/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.controller;

import hr.gregl.dal.ActorRepository;
import hr.gregl.dal.DirectorRepository;
import hr.gregl.dal.MovieActorDirectorRepository;
import hr.gregl.dal.MovieRepository;
import hr.gregl.dal.RepositoryFactory;
import hr.gregl.model.Actor;
import hr.gregl.model.Director;
import hr.gregl.model.Movie;
import hr.gregl.model.MovieActorDirector;
import java.util.List;

/**
 *
 * @author albert
 */
public class MovieActorDirectorController {

    private ActorRepository actorRepository;
    private MovieRepository movieRepository;
    private DirectorRepository directorRepository;
    private MovieActorDirectorRepository movieActorDirectorRepository;

    public MovieActorDirectorController() {
        this.actorRepository = RepositoryFactory.getActorRepository();
        this.movieRepository = RepositoryFactory.getMovieRepository();
        this.directorRepository = RepositoryFactory.getDirectorRepository();
        this.movieActorDirectorRepository = RepositoryFactory.getMovieActorDirectorRepository();
    }

    public Actor getActorById(int actorId) {
        return this.actorRepository.selectById(actorId);
    }

    public Director getDirectorById(int directorId) {
        return this.directorRepository.selectById(directorId);
    }

    public Movie getMovieById(int movieId) {
        return this.movieRepository.selectById(movieId);
    }

    public List<MovieActorDirector> selectAllMovieActorDirectors() {
        return this.movieActorDirectorRepository.selectAll();
    }

    public void addMovieActorDirector(MovieActorDirector mad) {
        this.movieActorDirectorRepository.add(mad);
    }

    public List<Director> getAllDirectors() {
        return this.directorRepository.selectAll();
    }

    public List<Actor> getAllActors() {
        return this.actorRepository.selectAll();
    }

    public List<Movie> getAllMovies() {
        return this.movieRepository.selectAll();
    }

}
