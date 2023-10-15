package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

//    public static Connection getConnection()  {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //set connection
//            Connection con = null;
//            try {
//                con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/management_system2", "root", "123456");
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            return con;
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //set connection
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/management_system33", "root", "123456");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return con;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

