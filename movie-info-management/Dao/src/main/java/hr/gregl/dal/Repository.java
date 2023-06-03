/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.gregl.dal;

import java.util.List;

/**
 *
 * @author albert
 */
public interface Repository<T> {
    void add(T item);
    void delete(int id);
    void update(T item);
    T selectById(int id);
    List<T> selectAll();
}
