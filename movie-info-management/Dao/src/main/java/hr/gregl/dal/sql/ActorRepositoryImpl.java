/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.dal.sql;

import hr.gregl.dal.ActorRepository;
import hr.gregl.model.Actor;
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
public class ActorRepositoryImpl implements ActorRepository {

    private static final String ID_ACTOR = "ActorID";
    private static final String NAME = "Name";
    private static final String DOB = "DOB";
    private static final String IMAGE_PATH = "ImagePath";

    private static final String ADD_ACTOR = "{ CALL addActor (?,?,?) }";
    private static final String ADD_ACTOR_AND_GET_ID = "{ CALL addActorAndGetId (?,?,?) }";
    private static final String DELETE_ACTOR = "{ CALL deleteActor (?) }";
    private static final String UPDATE_ACTOR = "{ CALL updateActor (?,?,?,?) }";
    private static final String SELECT_ACTOR = "{ CALL selectActor (?) }";
    private static final String SELECT_ALL_ACTORS = "{ CALL selectAllActors }";

    @Override
    public int addAndGetId(Actor item) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(ADD_ACTOR_AND_GET_ID)) {

            stmt.setString(NAME, item.getName());
            stmt.setString(DOB, item.getDob().format(DataSourceSingleton.DATE_FORMATTER));
            stmt.setString(IMAGE_PATH, item.getImagePath());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Id");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public void add(Actor item) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(ADD_ACTOR)) {

            stmt.setString(NAME, item.getName());
            stmt.setString(DOB, item.getDob().format(DataSourceSingleton.DATE_FORMATTER));
            stmt.setString(IMAGE_PATH, item.getImagePath());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ActorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ACTOR)) {

            stmt.setInt(ID_ACTOR, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ActorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Actor item) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_ACTOR)) {

            stmt.setInt(ID_ACTOR, item.getActorID());
            stmt.setString(NAME, item.getName());
            stmt.setString(DOB, item.getDob().format(DataSourceSingleton.DATE_FORMATTER));
            stmt.setString(IMAGE_PATH, item.getImagePath());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ActorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Actor selectById(int id) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ACTOR)) {

            stmt.setInt(ID_ACTOR, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new Actor(
                            rs.getInt(ID_ACTOR),
                            rs.getString(NAME),
                            LocalDate.parse(rs.getString(DOB), DataSourceSingleton.DATE_FORMATTER),
                            rs.getString(IMAGE_PATH));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Actor> selectAll() {
        List<Actor> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_ACTORS); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                actors.add(new Actor(
                        rs.getInt(ID_ACTOR),
                        rs.getString(NAME),
                        LocalDate.parse(rs.getString(DOB), DataSourceSingleton.DATE_FORMATTER),
                        rs.getString(IMAGE_PATH)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actors;
    }

}
