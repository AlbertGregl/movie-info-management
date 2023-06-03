/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.dal.sql;

import hr.gregl.dal.UserRepository;
import hr.gregl.model.Role;
import hr.gregl.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author albert
 */
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_ID = "UserID";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String ROLE = "RoleID";

    private static final String ADD_USER = "{ CALL addUser (?, ?, ?) }";
    private static final String DELETE_USER = "{ CALL deleteUser (?) }";
    private static final String UPDATE_USER = "{ CALL updateUser (?, ?, ?, ?) }";
    private static final String SELECT_USER_BY_ID = "{ CALL selectUser (?) }";
    private static final String SELECT_USER_BY_USERNAME = "{ CALL selectUserByUsername (?) }";
    private static final String SELECT_ALL_USERS = "{ CALL selectAllUsers }";


    @Override
    public User selectUserByUsername(String username) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_USER_BY_USERNAME)) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new User(
                            rs.getInt(USER_ID),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            Role.getById(rs.getInt(ROLE)));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(User user) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(ADD_USER)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getRole().getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_USER)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_USER)) {

            stmt.setInt(1, user.getUserID());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getRole().getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User selectById(int id) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_USER_BY_ID)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new User(
                            rs.getInt(USER_ID),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            Role.getById(rs.getInt(ROLE)));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_USERS); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt(USER_ID),
                        rs.getString(USERNAME),
                        rs.getString(PASSWORD),
                        Role.getById(rs.getInt(ROLE))));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
}
