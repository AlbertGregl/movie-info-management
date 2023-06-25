/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.parsers.rss.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author albert
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "item")
    private List<MovieRss> movies;

    public Channel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieRss> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieRss> movies) {
        this.movies = movies;
    }
}
