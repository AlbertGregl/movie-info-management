/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.gregl.dal;

import hr.gregl.model.User;
import java.util.List;

/**
 *
 * @author albert
 */
public interface UserRepository {

    void add(User user);

    void delete(User user);

    void update(User user);

    List<User> getAll();

    User get(int id);

    User getByUsername(String username);
}
