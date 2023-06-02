/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.dal;

import hr.gregl.model.Article0708;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author daniel.bele
 */
public interface Repository0708 {

    int createArticle(Article0708 article) throws Exception;

    void createArticles(List<Article0708> articles) throws Exception;

    void updateArticle(int id, Article0708 data) throws Exception;

    void deleteArticle(int id) throws Exception;

    Optional<Article0708> selectArticle(int id) throws Exception;

    List<Article0708> selectArticles() throws Exception;

}
