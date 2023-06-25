/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.model;

import java.time.LocalDate;

/**
 *
 * @author albert
 */
public final class Actor {

    private int actorID;
    private String name;
    private LocalDate dob;
    private String imagePath;

    public Actor() {
    }

    public Actor(String name, LocalDate dob, String imagePath) {
        this.name = name;
        this.dob = dob;
        this.imagePath = imagePath;
    }

    public Actor(int actorID, String name, LocalDate dob, String imagePath) {
        this(name, dob, imagePath);
        this.actorID = actorID;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
