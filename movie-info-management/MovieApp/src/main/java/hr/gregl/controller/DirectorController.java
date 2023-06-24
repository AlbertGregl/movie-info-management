/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.controller;

import hr.gregl.dal.ActorRepository;
import hr.gregl.dal.DirectorRepository;
import hr.gregl.dal.MovieRepository;
import hr.gregl.dal.RepositoryFactory;
import hr.gregl.model.Actor;
import hr.gregl.model.Director;
import hr.gregl.model.Movie;
import java.util.List;

/**
 *
 * @author albert
 */
public class DirectorController {

    private ActorRepository actorRepository;
    private MovieRepository movieRepository;
    private DirectorRepository directorRepository;

    public DirectorController() {
        this.actorRepository = RepositoryFactory.getActorRepository();
        this.movieRepository = RepositoryFactory.getMovieRepository();
        this.directorRepository = RepositoryFactory.getDirectorRepository();
    }

    public void createDirector(Director director) {
        this.directorRepository.add(director);
    }

    public void deleteDirector(int directorId) {
        this.directorRepository.delete(directorId);
    }

    public void updateDirector(Director director) {
        this.directorRepository.update(director);
    }

    public List<Director> getAllDirectors() {
        return this.directorRepository.selectAll();
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
}
