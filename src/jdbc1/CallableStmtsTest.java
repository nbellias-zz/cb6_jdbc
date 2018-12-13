/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Νικόλαος Μπέλλιας
 */
public class CallableStmtsTest {

    public static void main(String[] args) throws SQLException {
        String urlSakila = "jdbc:mysql://192.168.227.129:3306/sakila";
        String user = "nikolaos";
        String password = "Sp#r0s1967!";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an actor's name:");
        String actorNameLike = sc.nextLine();
        
        Connection conn = null;
        conn = DriverManager.getConnection(urlSakila, user, password);
        String storedPrecedureCall = "{call find_films_of_actor(?)}";
        CallableStatement cstmt = conn.prepareCall(storedPrecedureCall);
        cstmt.setString(1, actorNameLike);
        ResultSet rsStoredProc = cstmt.executeQuery();
        while (rsStoredProc.next()) {
            //first_name, last_name, title, release_year
            System.out.print(rsStoredProc.getString("first_name") + ", ");
            System.out.print(rsStoredProc.getString("last_name") + ", ");
            System.out.print(rsStoredProc.getString("title") + ", ");
            System.out.println(rsStoredProc.getInt("release_year"));
        }
    }
}
