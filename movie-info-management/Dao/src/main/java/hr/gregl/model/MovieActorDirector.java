/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.model;

/**
 *
 * @author albert
 *
 * MovieActorDirector represents a many-to-many relationship between movies,
 * actors, and directors.
 *
 */
public final class MovieActorDirector {

    private int movieId;
    private int actorId;
    private int directorId;

    public MovieActorDirector() {
    }

    public MovieActorDirector(int movieID, int actorID, int directorID) {
        this.movieId = movieID;
        this.actorId = actorID;
        this.directorId = directorID;
    }

    public int getMovieID() {
        return movieId;
    }

    public void setMovieID(int movieID) {
        this.movieId = movieID;
    }

    public int getActorID() {
        return actorId;
    }

    public void setActorID(int actorID) {
        this.actorId = actorID;
    }

    public int getDirectorID() {
        return directorId;
    }

    public void setDirectorID(int directorID) {
        this.directorId = directorID;
    }

    @Override
    public String toString() {
        return "MovieID: " + movieId + ", ActorID: " + actorId + ", DirectorID: " + directorId;
    }
}
