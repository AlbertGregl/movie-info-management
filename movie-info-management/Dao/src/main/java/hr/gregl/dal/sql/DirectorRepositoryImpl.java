/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.dal.sql;

import hr.gregl.dal.DirectorRepository;
import hr.gregl.model.Director;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author albert
 */
public class DirectorRepositoryImpl implements DirectorRepository {

    private static final String ID_DIRECTOR = "DirectorID";
    private static final String NAME = "Name";
    private static final String DOB = "DOB";
    private static final String IMAGE_PATH = "ImagePath";

    private static final String ADD_DIRECTOR = "{ CALL addDirector (?,?,?) }";
    private static final String ADD_DIRECTOR_AND_GET_ID = "{ CALL addDirectorAndGetId (?,?,?) }";
    private static final String DELETE_DIRECTOR = "{ CALL deleteDirector (?) }";
    private static final String UPDATE_DIRECTOR = "{ CALL updateDirector (?,?,?,?) }";
    private static final String SELECT_DIRECTOR = "{ CALL selectDirector (?) }";
    private static final String SELECT_ALL_DIRECTORS = "{ CALL selectAllDirectors }";
    
    @Override
    public int addAndGetId(Director item) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(ADD_DIRECTOR_AND_GET_ID)) {

            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDob().format(DataSourceSingleton.DATE_FORMATTER));
            stmt.setString(3, item.getImagePath());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Id");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DirectorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public void add(Director item) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(ADD_DIRECTOR)) {

            stmt.setString(NAME, item.getName());
            stmt.setString(DOB, item.getDob().format(DataSourceSingleton.DATE_FORMATTER));
            stmt.setString(IMAGE_PATH, item.getImagePath());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DirectorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_DIRECTOR)) {

            stmt.setInt(ID_DIRECTOR, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DirectorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Director item) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_DIRECTOR)) {

            stmt.setInt(ID_DIRECTOR, item.getDirectorID());
            stmt.setString(NAME, item.getName());
            stmt.setString(DOB, item.getDob().format(DataSourceSingleton.DATE_FORMATTER));
            stmt.setString(IMAGE_PATH, item.getImagePath());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DirectorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Director selectById(int id) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_DIRECTOR)) {

            stmt.setInt(ID_DIRECTOR, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new Director(
                            rs.getInt(ID_DIRECTOR),
                            rs.getString(NAME),
                            LocalDate.parse(rs.getString(DOB), DataSourceSingleton.DATE_FORMATTER),
                            rs.getString(IMAGE_PATH));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DirectorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Director> selectAll() {
        List<Director> directors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_DIRECTORS); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                directors.add(new Director(
                        rs.getInt(ID_DIRECTOR),
                        rs.getString(NAME),
                        LocalDate.parse(rs.getString(DOB), DataSourceSingleton.DATE_FORMATTER),
                        rs.getString(IMAGE_PATH)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DirectorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return directors;
    }
}
