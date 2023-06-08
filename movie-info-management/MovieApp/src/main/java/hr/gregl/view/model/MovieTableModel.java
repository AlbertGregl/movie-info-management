/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.view.model;

import hr.gregl.model.Movie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author albert
 */
public class MovieTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Movie ID", "Title", "Genre", "Release Year", "Image Path"};

    private List<Movie> movies;

    public MovieTableModel(List<Movie> movies) {
        this.movies = movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movie movie = movies.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return movie.getMovieID();
            case 1:
                return movie.getTitle();
            case 2:
                return movie.getGenre();
            case 3:
                return movie.getReleaseYear();
            case 4:
                return movie.getImagePath();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0 || columnIndex == 3) {
            return Integer.class;
        }
        return super.getColumnClass(columnIndex); 
    }
}
