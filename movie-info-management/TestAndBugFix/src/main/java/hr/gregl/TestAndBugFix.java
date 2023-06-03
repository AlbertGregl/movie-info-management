/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package hr.gregl;

import hr.gregl.service.DatabaseService;
import java.sql.SQLException;

/**
 *
 * @author albert
 */
public class TestAndBugFix {

    public static void main(String[] args) {

        try {
            
            // Initialize the database
            System.out.println("Initializing database...");
            DatabaseService.initializeDatabase();
            System.out.println("Database initialized successfully.");


            // delete database
            // System.out.println("Deleting database...");
            // DatabaseService.deleteDatabase();
            // System.out.println("Database deleted successfully.");
            
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}