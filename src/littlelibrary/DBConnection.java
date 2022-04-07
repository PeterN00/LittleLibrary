/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littlelibrary;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class DBConnection {
    static String url = "jdbc:mysql://localhost:3306/librarymanagement";
    static String user = "root";
    static String password = "";
    public static Connection getCon() throws SQLException{
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
}
