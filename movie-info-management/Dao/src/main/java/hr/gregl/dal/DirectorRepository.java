/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.gregl.dal;

import hr.gregl.model.Director;
import java.util.List;

/**
 *
 * @author albert
 */
public interface DirectorRepository extends Repository<Director> {
    List<Director> searchByMovie(String movieTitle);
}
