/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.gregl.dal;

import hr.gregl.model.MovieActorDirector;
import java.util.List;

/**
 *
 * @author albert
 */
public interface MovieActorDirectorRepository {

    void add(MovieActorDirector mad);

    void delete(MovieActorDirector mad);

    void update(MovieActorDirector mad);

    List<MovieActorDirector> getAll();

    MovieActorDirector get(int movieID, int actorID, int directorID);
}
