/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.gregl.dal;

import hr.gregl.model.Movie;
import java.util.List;

/**
 *
 * @author albert
 */
public interface MovieRepository extends Repository<Movie> {

    List<Movie> searchByTitle(String title);

    List<Movie> searchByGenre(String genre);

    List<Movie> searchByYear(int year);

    List<Movie> searchByDirector(String directorName);

    List<Movie> searchByActor(String actorName);
}
