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
    void delete(int movieId, int actorId, int directorId);
    MovieActorDirector selectById(int movieId, int actorId, int directorId);
    List<MovieActorDirector> selectAll();
}
