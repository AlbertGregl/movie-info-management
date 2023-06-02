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

    private int movieID;
    private int actorID;
    private int directorID;

    public MovieActorDirector() {
    }

    public MovieActorDirector(int movieID, int actorID, int directorID) {
        this.movieID = movieID;
        this.actorID = actorID;
        this.directorID = directorID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }

    @Override
    public String toString() {
        return "MovieID: " + movieID + ", ActorID: " + actorID + ", DirectorID: " + directorID;
    }
}
