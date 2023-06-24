/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.view.model;

import hr.gregl.model.Director;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author alber
 */
public class DirectorTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Director ID", "Name", "Date Of Birth", "Image Path"};
    private static final int[] COLUMN_WIDTHS = {30, 150, 100, 200};

    private List<Director> directors;

    public DirectorTableModel(List<Director> directors) {
        this.directors = directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return directors.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Director director = directors.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return director.getDirectorID();
            case 1:
                return director.getName();
            case 2:
                return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(director.getDob());
            case 3:
                return director.getImagePath();
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
        if (columnIndex == 0) {
            return Integer.class;
        } else if (columnIndex == 2) {
            return LocalDate.class;
        }
        return super.getColumnClass(columnIndex);
    }

    public void setColumnWidths(JTable table) {
        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(COLUMN_WIDTHS[i]);
        }
    }
}
