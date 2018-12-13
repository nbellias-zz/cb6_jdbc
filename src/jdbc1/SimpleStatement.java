/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Νικόλαος Μπέλλιας
 */
public class SimpleStatement {

    public static void main(String[] args) throws SQLException {
        String urlSakila = "jdbc:mysql://192.168.227.129:3306/sakila";
        String user = "nikolaos";
        String password = "Sp#r0s1967!";

        Connection conn = null;
        conn = DriverManager.getConnection(urlSakila, user, password);
        String sql = "select count(*) as cnt from actor";
        Statement stmt = conn.createStatement();
        ResultSet rs2 = stmt.executeQuery(sql);
        while (rs2.next()) {
            System.out.println(rs2.getInt("cnt"));
        }
    }

}
