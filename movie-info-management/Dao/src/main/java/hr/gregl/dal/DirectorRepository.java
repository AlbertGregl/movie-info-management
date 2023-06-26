/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.gregl.dal;

import hr.gregl.model.Director;

/**
 *
 * @author albert
 */
public interface DirectorRepository extends Repository<Director> {

    public int addAndGetId(Director item);
}
