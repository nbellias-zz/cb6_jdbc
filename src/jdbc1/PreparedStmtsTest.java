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

/**
 *
 * @author Νικόλαος Μπέλλιας
 */
public class PreparedStmtsTest {

    public static void main(String[] args) {
        String urlSalesdb = "jdbc:mysql://192.168.227.129:3306/SalesDB";
        String urlSakila = "jdbc:mysql://192.168.227.129:3306/sakila";
        String user = "nikolaos";
        String password = "Sp#r0s1967!";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(urlSakila, user, password);
            String sql = "select count(*) as cnt from actor";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("cnt"));
            }
            
            pstmt.close();
            rs.close();
            conn.close();

        } catch (SQLException ex) {

        }

    }
}
