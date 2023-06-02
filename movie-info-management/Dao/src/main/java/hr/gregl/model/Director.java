/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.model;

import java.util.Date;

/**
 *
 * @author albert
 */
public final class Director {

    private int directorID;
    private String name;
    private Date dob;
    private String imagePath;

    public Director() {
    }

    public Director(String name, Date dob, String imagePath) {
        this.name = name;
        this.dob = dob;
        this.imagePath = imagePath;
    }

    public Director(int directorID, String name, Date dob, String imagePath) {
        this(name, dob, imagePath);
        this.directorID = directorID;
    }

    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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
        return directorID + " - " + name + " - " + dob.toString();
    }
}
