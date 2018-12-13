/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Νικόλαος Μπέλλιας
 */
public class MySQLConnection {
    
    public static Connection connect() throws SQLException {
        String urlSakila = "jdbc:mysql://192.168.227.129:3306/sakila";
        String user = "nikolaos";
        String password = "Sp#r0s1967!";
        
        return DriverManager.getConnection(urlSakila, user, password);
    }

    
}
