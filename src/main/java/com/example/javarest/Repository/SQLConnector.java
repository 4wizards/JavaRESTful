package com.example.javarest.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnector {
    static Connection con;

    SQLConnector(){
        try {
            //Uncomment to run in localhost
            Property p = new Property();
            con = DriverManager.getConnection(p.getConnectionString(),p.getUserName(), p.getPassword());

            //con = DriverManager.getConnection(System.getenv("MYSQLDB"),System.getenv("USERNAME"), System.getenv("PASSWORD"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection GetConnected(){
        new SQLConnector();
        return con;
    }
}
