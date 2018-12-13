/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Νικόλαος Μπέλλιας
 */
public class InsertUpdateDeleteStmts {

    public static void main(String[] args) throws SQLException {
        String urlSakila = "jdbc:mysql://192.168.227.129:3306/sakila";
        String user = "nikolaos";
        String password = "Sp#r0s1967!";

        String sqlCreateTable = "create table test(t_id integer not null,\n"
                + "t_name varchar(50) not null,\n"
                + "primary key (t_id))";

        String sqlInsertTable1 = "insert into test(t_id, t_name) values(1,'kostas')";
        String sqlInsertTable2 = "insert into test(t_id, t_name) values(2,'maria')";
        String sqlInsertTable3 = "insert into test(t_id, t_name) values(3,'giorgos')";

        String sqlUpdateTable = "update test set t_name = 'andreas' where t_id = 1";

        String sqlDeleteTuple = "delete from test where t_id = " + 3;

        String sqlCreateTableAsSelect = "create table test1 as select * from test";

        String sqlDropTable = "drop table test1";

        Connection conn = DriverManager.getConnection(urlSakila, user, password);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sqlCreateTable);
        stmt.executeUpdate(sqlInsertTable1);
        stmt.executeUpdate(sqlInsertTable2);
        stmt.executeUpdate(sqlInsertTable3);
        stmt.executeUpdate(sqlUpdateTable);
        stmt.executeUpdate(sqlDeleteTuple);
        stmt.executeUpdate(sqlCreateTableAsSelect);
        stmt.executeUpdate(sqlDropTable);
        
        
        stmt.close();
        conn.close();
    }

}
