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

        dbService.fillDatabaseWithMockData();


    }
}
