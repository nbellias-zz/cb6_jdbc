/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Νικόλαος Μπέλλιας
 */
public class JDBC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String urlSalesdb = "jdbc:mysql://192.168.227.129:3306/SalesDB";
        String urlSakila = "jdbc:mysql://192.168.227.129:3306/sakila";
        String user = "nikolaos";
        String password = "Sp#r0s1967!";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urlSalesdb, user, password);
            String sql = "select count(*) as cnt from Customers";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs1 = pstmt.executeQuery();
            while (rs1.next()) {
                System.out.println(rs1.getInt("cnt"));
            }

            Statement stmt = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery(sql);
            while (rs2.next()) {
                System.out.println(rs2.getInt("cnt"));
            }

            //conn = DriverManager.getConnection(urlSakila, user, password);
            sql = "select count(*) as cnt from Employees";
            stmt = conn.createStatement();
            rs2 = stmt.executeQuery(sql);

            while (rs2.next()) {
                System.out.println(rs2.getInt("cnt"));
            }

            conn.close();
        } catch (SQLException ex) {

        }

        // My statements
    }

}
