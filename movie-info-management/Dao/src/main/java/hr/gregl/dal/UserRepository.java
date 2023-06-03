/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.gregl.dal;

import hr.gregl.model.User;

/**
 *
 * @author albert
 */
public interface UserRepository extends Repository<User> {
    User selectUserByUsername(String username);
}
