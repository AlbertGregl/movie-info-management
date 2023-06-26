/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.service;

import hr.gregl.dal.sql.DataSourceSingleton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author albert
 */
public class DatabaseService {

    private static final String FILL_DATA_SCRIPT_PATH = "scripts/fillMovieInfoDB.sql";
    private static final String DELETE_DATA_SCRIPT_PATH = "scripts/deleteMovieInfoDBData.sql";

    private static final Logger LOGGER = Logger.getLogger(DatabaseService.class.getName());

    public void fillDatabaseWithMockData() {
        LOGGER.info("Filling database with data...");
        executeSqlScript(FILL_DATA_SCRIPT_PATH);
    }

    public void deleteAllDataFromDatabase() {
        LOGGER.info("Deleting all data from database...");
        executeSqlScript(DELETE_DATA_SCRIPT_PATH);
    }

    private void executeSqlScript(String scriptPath) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(scriptPath)) {
            if (is == null) {
                throw new FileNotFoundException("Cannot find SQL script: " + scriptPath);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                StringBuilder sql = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sql.append(line);
                    if (line.endsWith(";")) {
                        try (Connection connection = DataSourceSingleton.getInstance().getConnection(); Statement statement = connection.createStatement()) {
                            statement.execute(sql.toString());
                            sql = new StringBuilder();
                        } catch (SQLException ex) {
                            LOGGER.log(Level.SEVERE, "Failed to execute SQL script: " + scriptPath, ex);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to load SQL script: " + scriptPath, ex);
        }
    }

    public boolean testDatabaseConnection() {
        try (Connection connection = DataSourceSingleton.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("SELECT 1");
            return true;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Failed to connect to the database.", ex);
            return false;
        }
    }

}
