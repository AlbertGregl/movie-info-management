/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package hr.gregl;

import hr.gregl.service.DatabaseService;

/**
 *
 * @author albert
 */
public class TestAndBugFix {

    public static void main(String[] args) {
        DatabaseService dbService = new DatabaseService();

        System.out.println("Filling database with data...");
        dbService.fillDatabaseWithMockData();
        System.out.println("Data has been inserted successfully.");

    }
}
