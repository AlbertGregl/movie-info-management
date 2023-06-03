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
public final class Director {

    private int directorId;
    private String name;
    private LocalDate dob;
    private String imagePath;

    public Director() {
    }

    public Director(String name, LocalDate dob, String imagePath) {
        this.name = name;
        this.dob = dob;
        this.imagePath = imagePath;
    }

    public Director(int directorID, String name, LocalDate dob, String imagePath) {
        this(name, dob, imagePath);
        this.directorId = directorID;
    }

    public int getDirectorID() {
        return directorId;
    }

    public void setDirectorID(int directorID) {
        this.directorId = directorID;
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
        return directorId + " - " + name + " - " + dob.toString();
    }
}
