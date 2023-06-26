/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.controller;

import hr.gregl.dal.RepositoryFactory;
import hr.gregl.dal.UserRepository;
import hr.gregl.model.User;
import java.util.List;

/**
 *
 * @author albert
 */
public class LoginController {

    private UserRepository userRepository;

    public LoginController() {
        this.userRepository = RepositoryFactory.getUserRepository();
    }

    // user login
    public User login(String username, String password) {
        List<User> users = this.userRepository.selectAll();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // user registration
    public void register(User user) {
        this.userRepository.add(user);
    }

}
