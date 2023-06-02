/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.gregl.dal;

/**
 *
 * @author albert
 */
public interface Repository<T> {
    T create(T t);
    T read(int id);
    T update(T t);
    void delete(int id);
}
