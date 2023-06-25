/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.controller;

import hr.gregl.dal.RepositoryFactory;
import hr.gregl.dal.UserRepository;
import hr.gregl.model.User;
import hr.gregl.parsers.rss.MovieParser;
import hr.gregl.service.DatabaseService;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 *
 * @author albert
 */
public class AdminController {

    private UserRepository userRepository;
    private DatabaseService databaseService;

    public AdminController() {
        this.userRepository = RepositoryFactory.getUserRepository();
        this.databaseService = new DatabaseService();
    }

    // CRUD operations for User
    public void addUser(User user) {
        this.userRepository.add(user);
    }

    public void deleteUser(int userId) {
        this.userRepository.delete(userId);
    }

    public void updateUser(User user) {
        this.userRepository.update(user);
    }

    public User getUserById(int id) {
        return this.userRepository.selectById(id);
    }

    public List<User> getAllUsers() {
        return this.userRepository.selectAll();
    }

    // Operation for deleting all data in the database
    public void deleteAllDataFromDatabase() {
        this.databaseService.deleteAllDataFromDatabase();
    }

    // Operation for parsing and saving data from an RSS feed
    public void parseAndSaveDataFromRSS() {
        MovieParser movieParser = new MovieParser();
        try {
            movieParser.parseAndSaveDataFromRSS();
        } catch (IOException | JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
