/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.controller;

import hr.gregl.dal.DirectorRepository;
import hr.gregl.dal.RepositoryFactory;
import hr.gregl.model.Director;
import java.util.List;

/**
 *
 * @author albert
 */
public class DirectorController {

    private DirectorRepository directorRepository;

    public DirectorController() {
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

    public Director getDirectorById(int directorId) {
        return this.directorRepository.selectById(directorId);
    }

    public List<Director> getAllDirectors() {
        return this.directorRepository.selectAll();
    }
}
