/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.service;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.sql.DataSource;

/**
 *
 * @author albert
 */
public class DatabaseService {

    private static final String PATH = "/config/db.properties";
    private static final String SERVER_NAME = "SERVER_NAME";
    private static final String USER = "USER";
    private static final String PASSWORD = "PASSWORD";
    private static final Properties properties = new Properties();

    private static final String CREATE_DATABASE_SCRIPT_PATH = "/scripts/createMovieInfoDB.sql";
    private static final String DELETE_DATABASE_SCRIPT_PATH = "/scripts/deleteMovieInfoDB.sql";

public static void executeSqlScript(DataSource dataSource, String scriptPath) throws SQLException {
    try (Connection connection = dataSource.getConnection()) {
        Statement statement = connection.createStatement();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DatabaseService.class.getResourceAsStream(scriptPath)));

        String script = reader.lines().collect(Collectors.joining("\n"));
        String[] commands = script.split("GO");

        for (String command : commands) {
            String trimmedCommand = command.trim();
            if (trimmedCommand.length() > 0 && !trimmedCommand.startsWith("--")) {
                boolean result = statement.execute(trimmedCommand);
                if (!result) {
                    throw new SQLException("Failed to execute command: " + trimmedCommand);
                }
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        throw new SQLException("Failed to execute script: " + scriptPath, ex);
    }
}

    public static void initializeDatabase() throws SQLException {
        DataSource serverDataSource = getServerDataSource();
        executeSqlScript(serverDataSource, CREATE_DATABASE_SCRIPT_PATH);
    }

    public static void deleteDatabase() throws SQLException {
        DataSource serverDataSource = getServerDataSource();
        executeSqlScript(serverDataSource, DELETE_DATABASE_SCRIPT_PATH);
    }

    private static DataSource getServerDataSource() {
        SQLServerDataSource serverDataSource = new SQLServerDataSource();
        loadProperties();

        serverDataSource.setServerName(properties.getProperty(SERVER_NAME));
        serverDataSource.setUser(properties.getProperty(USER));
        serverDataSource.setPassword(properties.getProperty(PASSWORD));
        return serverDataSource;
    }

    private static void loadProperties() {
        try (InputStream is = DatabaseService.class.getResourceAsStream(PATH)) {
            properties.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
