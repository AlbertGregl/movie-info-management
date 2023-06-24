/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.view.model;

import hr.gregl.controller.ActorController;
import hr.gregl.model.MovieActorDirector;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author albert
 */
public class MovieActorDirectorTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Movie", "Actor", "Director"};

    private ActorController actorController;

    public MovieActorDirectorTableModel(ActorController actorController) {
        this.actorController = actorController;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public int getRowCount() {
        return actorController.selectAllMovieActorDirectors().size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MovieActorDirector mad = actorController.selectAllMovieActorDirectors().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return actorController.getMovieById(mad.getMovieID()).getTitle();
            case 1:
                return actorController.getActorById(mad.getActorID()).getName();
            case 2:
                return actorController.getDirectorById(mad.getDirectorID()).getName();
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }

    public MovieActorDirector getMovieActorDirectorAt(int rowIndex) {
        return actorController.selectAllMovieActorDirectors().get(rowIndex);
    }
}

